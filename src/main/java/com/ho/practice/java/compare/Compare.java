package com.ho.practice.java.compare;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Compare {

	public static void main(String[] args) {
		
		List<String> versionList1 = Arrays.asList(new String("1.0.1"),
				new String("1.1.1")
				);
		List<String> versionList2 = Arrays.asList(new String("1.0.1"),
				new String("1.1.1"),
				new String("1.1.2")
				);
		List<String> versionList3 = Arrays.asList(
				new String("2.0.1"),
				new String("1.0.1"),
				new String("1.1.1"),
				new String("1.1.2")
				);
		
		Optional<String> maxVertion1 = versionList1.stream().max(String::compareToIgnoreCase);
		Optional<String> maxVertion2 = versionList2.stream().max(String::compareToIgnoreCase);
		Optional<String> maxVertion3 = versionList3.stream().max(String::compareToIgnoreCase);
		
		if(maxVertion1.get().equals("1.1.1")) {
			System.out.println(maxVertion1);
		}
		if(maxVertion2.get().equals("1.1.2")) {
			System.out.println(maxVertion2);
		}
		if(maxVertion3.get().equals("2.0.1")) {
			System.out.println(maxVertion3);
		}
		
    }
	
}
