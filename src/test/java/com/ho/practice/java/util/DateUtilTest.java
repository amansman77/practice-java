package com.ho.practice.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void getNowTest() {
		//given
		
		//when
		String date = DateUtil.getNow(DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS);
		
		//then
		assertNotNull(date);
		assertEquals(14, date.length());
	}

	@Test
	public void toStringTest() {
		//given
		LocalDateTime time = LocalDateTime.of(2019, 10, 22, 9, 50, 1);
		
		//when
		String date = DateUtil.toString(time, DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS);
		
		//then
		assertNotNull(date);
		assertEquals(14, date.length());
		assertEquals("20191022095001", date);
	}
	
	@Test
	public void getLocalDateTimeTest() {
		//given
		
		//when
		LocalDateTime time = DateUtil.getLocalDateTime("20191022095001", DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS);
		
		//then
		assertNotNull(time);
		assertEquals(2019, time.getYear());
		assertEquals(10, time.getMonthValue());
		assertEquals(22, time.getDayOfMonth());
		assertEquals(9, time.getHour());
		assertEquals(50, time.getMinute());
		assertEquals(1, time.getSecond());
	}
	
	@Test
	public void test() {
//		String s = "ab";
//		s.length();
//		String subS = s.substring(0, 1);
//		System.out.println(subS);
//		
//		subS.equals("");
	}
	
}
