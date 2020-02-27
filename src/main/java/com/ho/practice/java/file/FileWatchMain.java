package com.ho.practice.java.file;

public class FileWatchMain {

	public static void main(String[] args) {
		
		FileWatchService fileWatchService = new FileWatchService();
		fileWatchService.startWatch("C:/test-svn-directory", 20);
		
    }
	
}
