package com.ho.practice.java;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ho.practice.java.date.DateUtil;

public class DateUtilTest {

	@Test
	public void getNowTest() {
		//given
		
		//when
		String date = DateUtil.getNow(DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS);
		
		//then
		assertThat(date).isNotNull();
		assertThat(date.length()).isEqualTo(14);
		
	}

	@Test
	public void toStringTest() {
		//given
		LocalDateTime time = LocalDateTime.of(2019, 10, 22, 9, 50, 1);
		
		//when
		String date = DateUtil.toString(time, DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS);
		
		//then
		assertThat(date).isNotNull();
		assertThat(date.length()).isEqualTo(14);
		assertThat(date).isEqualTo("20191022095001");
		
	}
	
	@Test
	public void getLocalDateTimeTest() {
		//given
		
		//when
		LocalDateTime time = DateUtil.getLocalDateTime("20191022095001", DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS);
		
		//then
		assertThat(time).isNotNull();
		assertThat(time.getYear()).isEqualTo(2019);
		assertThat(time.getMonthValue()).isEqualTo(10);
		assertThat(time.getDayOfMonth()).isEqualTo(22);
		assertThat(time.getHour()).isEqualTo(9);
		assertThat(time.getMinute()).isEqualTo(50);
		assertThat(time.getSecond()).isEqualTo(1);
		
	}
	
}
