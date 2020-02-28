package com.ho.practice.java.file;

import java.util.ArrayList;
import java.util.List;

public class FileWatchLoop {
	
	private List<FileWatchEvent> events = new ArrayList<>();
	private boolean isRunning = true;

	public void startWatch(String filePath) {
		FileWatchService fileWatchService = new FileWatchService(filePath);
		fileWatchService.registRecursive();
		
		while (isRunning) {
			List<String> filePaths = fileWatchService.take();
			for (FileWatchEvent event: events) {
				event.run(filePaths);
			}
		}
    }
	
	public void stopWatch() {
		isRunning = false;
	}

	public void addWatchEvent(FileWatchEvent fileWatchEvent) {
		events.add(fileWatchEvent);
	}
	
}
