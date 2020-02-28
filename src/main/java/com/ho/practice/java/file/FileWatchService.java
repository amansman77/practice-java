package com.ho.practice.java.file;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import com.sun.nio.file.SensitivityWatchEventModifier;

public class FileWatchService {

	private WatchService watchService;
	private final Map<WatchKey, Path> keys = new HashMap<>();
	
	private String rootFilePath;
	
	public FileWatchService(String rootFilePath) {
		try {
			watchService = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.rootFilePath = rootFilePath;
	}
	
	public void regist(Path path) {
		try {
			System.out.println("registering " + path + " in watcher service");
			
			WatchKey watchKey = path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
			keys.put(watchKey, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void registRecursive() {
		System.out.println("Starting Recursive Watcher");
	
		Path path = Paths.get(this.rootFilePath);
		
	    Consumer<Path> register = p -> {
	        if (!p.toFile().exists() || !p.toFile().isDirectory()) {
	            throw new RuntimeException("folder " + p + " does not exist or is not a directory");
	        }
	        try {
	            Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
	                @Override
	                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	                	System.out.println("registering " + dir + " in watcher service");
	                	
	                    WatchKey watchKey = dir.register(watchService, new WatchEvent.Kind[]{ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE}, SensitivityWatchEventModifier.HIGH);
	                    keys.put(watchKey, dir);
	                    return FileVisitResult.CONTINUE;
	                }
	            });
	        } catch (IOException e) {
	            throw new RuntimeException("Error registering path " + p);
	        }
	    };
	
	    register.accept(path);
	}

	private void unRegist(String filePath) {
		Iterator<Entry<WatchKey, Path>> keysIterator = keys.entrySet().iterator();
		while (keysIterator.hasNext()) {
			Entry<WatchKey, Path> keysEntry = keysIterator.next();
			if (keysEntry.getValue().equals(Paths.get(filePath))) {
				System.out.println("unregistering " + filePath + " in watcher service");
				keysEntry.getKey().cancel();
				keys.remove(keysEntry.getKey());
				break;
			}
		}
	}

	public void take() {
		try {
			WatchKey watchKey = watchService.take();
			Path path = keys.get(watchKey);
            for (WatchEvent<?> event : watchKey.pollEvents()) {
            	WatchEvent.Kind<?> kind = event.kind();
            	Path name = (Path) event.context();
            	String eventFilePath = path + File.separator + name;
            	
            	System.out.println(kind + ", count : " + event.count());
            	System.out.println("key path : " + eventFilePath);
            	
            	if (kind.equals(ENTRY_CREATE)) {
            		regist(Paths.get(eventFilePath));
				} else if (kind.equals(ENTRY_DELETE)) {
					unRegist(eventFilePath);
				}
            }
            watchKey.reset();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
