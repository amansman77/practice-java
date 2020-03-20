package com.ho.practice.java.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void testIndexOf_matching() {
		String target = "svn.repository.default.uri";
		
		assertEquals(0, target.indexOf("svn.repository"));
		assertEquals(0, target.lastIndexOf("svn.repository"));
		
		target = "test.svn.repository.default.uri";
		
		assertEquals(5, target.indexOf("svn.repository"));
	}
	
	@Test
	public void testIndexOf_noMatching() {
		String target = "test.repository";
		
		assertEquals(-1, target.indexOf("svn.repository"));
	}
	
	@Test
	public void testExtractString() {
		String target = "svn.repository.default.uri";
		String replaceTarget = target.replace("svn.repository.", "");
		String[] tokens = replaceTarget.split("\\.");
		String key = tokens[0];
		
		assertEquals("default", key);
		assertEquals("uri", tokens[1]);
	}

}
