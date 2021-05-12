package com.ho.practice.java.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class FileUtilTest {

	@Test
	public void testSearchDirectory() {
		String directory = FileUtil.searchDirectory("build.xml", "C:/test-svn-directory/project/src/94.txt");

		assertEquals("C:/test-svn-directory/project", directory.replace("\\", "/"));
	}

}
