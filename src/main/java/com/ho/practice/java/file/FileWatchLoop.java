package com.ho.practice.java.file;

public class FileWatchLoop {
	
	boolean isRunning = true;

	public void startWatch(String filePath) {
		FileWatchService fileWatchService = new FileWatchService(filePath);
		fileWatchService.registRecursive();
		
		while (isRunning) {
			fileWatchService.take();
		}
    }
	
	public void stopWatch() {
		isRunning = false;
	}
	
}
