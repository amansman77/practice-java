package com.ho.practice.java.file;

public class FileWatchRunner implements Runnable {

	private FileWatchService fileWatchService;
	
	public FileWatchRunner(String filePath) {
		fileWatchService = new FileWatchService(filePath);
		fileWatchService.registRecursive();
	}
	
	@Override
	public void run() {
		System.out.println("Run!!");
		
		fileWatchService.take();
	}
	
}
