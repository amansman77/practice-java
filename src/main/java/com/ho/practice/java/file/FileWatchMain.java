package com.ho.practice.java.file;

public class FileWatchMain {

	public static void main(String[] args) {
		
//		FileWatchScheduler fileWatchScheduler = new FileWatchScheduler();
//		fileWatchScheduler.startWatch("C:/test-svn-directory", 20);
		
		FileWatchLoop fileWatchLoop = new FileWatchLoop();
		
		FileWatchEvent fileWatchEvent = (filePaths) -> {
			System.out.println("Event : " + filePaths);
		};
		fileWatchLoop.addWatchEvent(fileWatchEvent);
		
		fileWatchLoop.startWatch("C:/test-svn-directory");
		
    }
	
}
