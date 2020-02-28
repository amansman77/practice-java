package com.ho.practice.java.file;

import java.util.List;

public interface FileWatchEvent {
	
	void run(List<String> filePaths);
	
}
