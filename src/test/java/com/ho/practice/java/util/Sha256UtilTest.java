package com.ho.practice.java.util;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class Sha256UtilTest {

	@Test
	public void 암호화() throws NoSuchAlgorithmException {
		//given
		String pw = "pass1234";
		
		//when
		String newPw = Sha256Util.encode(pw);
	    
		//then
		assertNotNull(newPw);
		assertNotEquals(pw, newPw);
	}

	@Test
	public void 암호화_비교() throws NoSuchAlgorithmException {
		//given
		String pw = "pass1234";
		
		//when
		String newPw = Sha256Util.encode(pw);
		String newPw2 = Sha256Util.encode(pw);
	    
		//then
		assertNotNull(newPw);
		assertTrue(newPw2.equals(newPw));
	}
	
}
