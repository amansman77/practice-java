package com.ho.practice.java.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ho.practice.java.util.FileUtil;

public class FileUtilTest {

	@Test
	public void testSearchDirectory() {
		String directory = FileUtil.searchDirectory("build.xml", "C:/test-svn-directory/project/src/94.txt");

		assertEquals("C:/test-svn-directory/project", directory.replace("\\", "/"));
	}

}
