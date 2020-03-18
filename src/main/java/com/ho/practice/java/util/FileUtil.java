package com.ho.practice.java.util;

import java.io.File;
import java.io.FilenameFilter;

public class FileUtil {
	
	public static String searchDirectory(String fileName, String path) {
		File file = new File(path);
		
		File directory;
		if (!file.isDirectory()) {
			directory = file.getParentFile();
		} else {
			directory = new File(path);
		}
		while (!containFile(directory, fileName)) {
			directory = directory.getParentFile();
		}
		
		return directory.getPath();
	}
	
	private static boolean containFile(File directory, String fileName) {
		File[] files = directory.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return fileName.equals(name);
			}
		});
		if (files.length < 1) {
			return false;
		}
		
		return true;
	}
	
}
