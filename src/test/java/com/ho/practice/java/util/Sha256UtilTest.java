package com.ho.practice.java.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Sha256UtilTest {

	@Test
	public void 암호화() throws NoSuchAlgorithmException {
		//given
		String pw = "pass1234";
		
		//when
		String newPw = Sha256Util.encode(pw);
	    
		//then
		assertThat(newPw).isNotNull();
		assertThat(newPw).isNotEqualTo(pw);
	}

	@Test
	public void 암호화_비교() throws NoSuchAlgorithmException {
		//given
		String pw = "pass1234";
		
		//when
		String newPw = Sha256Util.encode(pw);
		String newPw2 = Sha256Util.encode(pw);
	    
		//then
		assertThat(newPw).isNotNull();
		assertThat(newPw).isEqualTo(newPw2);
	}
	
}
