package com.ho.practice.java.file;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

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
import java.util.Map;
import java.util.function.Consumer;

import com.sun.nio.file.SensitivityWatchEventModifier;

public class FileWatchRunner implements Runnable {

	private WatchService watchService;
	
	public FileWatchRunner(String filePath) {
		try {
			watchService = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		regist(Paths.get(filePath));
		registRecursive(Paths.get(filePath));
	}
	
	private void regist(Path path) {
		try {
			path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registRecursive(Path path) {
		System.out.println("Starting Recursive Watcher");

        final Map<WatchKey, Path> keys = new HashMap<>();

        Consumer<Path> register = p -> {
            if (!p.toFile().exists() || !p.toFile().isDirectory()) {
                throw new RuntimeException("folder " + p + " does not exist or is not a directory");
            }
            try {
                Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    	System.out.println("registering " + dir + " in watcher service");
                    	
                        WatchKey watchKey = dir.register(watchService, new WatchEvent.Kind[]{ENTRY_CREATE}, SensitivityWatchEventModifier.HIGH);
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
	
	@Override
	public void run() {
		System.out.println("Run!!");
		
		try {
			WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
            	WatchEvent.Kind<?> kind = event.kind();
            	Path paths = (Path) event.context();
            	System.out.println(kind + " : " +paths + ", count : " + event.count());
            }
            key.reset();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
