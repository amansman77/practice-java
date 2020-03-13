package com.ho.practice.java.collection.sample;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ListSampleTest {

	@Test
	public void testMapToList() {
		ListSample listSample = new ListSample();
		List<String> list = listSample.mapToList(
				Stream.of(new Object[][] {
				    { "key1", "value1" },
				    { "key2", "value2" }
				}).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]))
				);
		
		assertEquals(2, list.size());
		assertEquals(true, list.contains("value1"));
		assertEquals(false, list.contains("value3"));
	}

}
