package com.ho.practice.java.file;

public class FileWatchMain {

	public static void main(String[] args) {
		
//		FileWatchScheduler fileWatchScheduler = new FileWatchScheduler();
//		fileWatchScheduler.startWatch("C:/test-svn-directory", 20);
		
		FileWatchLoop fileWatchLoop = new FileWatchLoop();
		fileWatchLoop.startWatch("C:/test-svn-directory");
		
    }
	
}
