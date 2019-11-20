package com.ho.practice.java.collection.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Set을 활용해보는 클래스
 *
 */
public class SetSample {
	public static void main(String[] args) {
		List<String> testData = Arrays.asList("123", "234", "345", "123");
		System.out.println("Test data : " + testData);
		
		// 생성자
//		Set<Integer> example1 = new HashSet<>(Arrays.asList(1, 2, 3));
//		Set<Integer> example1 = c.stream().collect(Collectors.toSet());
//		Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
		
		SetSample ss = new SetSample();
		ss.findUniqeValue(testData);
		ss.findUniqeValueAndDuplicate(testData);
		ss.containsAll(testData);
		ss.addAll(testData);
		ss.retainAll(testData);
		ss.removeAll(testData);
    }
	
	/**
	 * input value 중 유일한 값을 출력하는 함수
	 * @param testData
	 */
	public void findUniqeValue(List<String> testData) {
		Set<String> distinctWords = testData.stream().collect(Collectors.toSet());
        System.out.println(distinctWords.size()+ 
                           " distinct words: " + 
                           distinctWords);
    }
	
	/**
	 * input value 중 1개만 있는 값과 그 이상을 가지는 값 분류 하는 함수
	 * @param testData
	 */
	public void findUniqeValueAndDuplicate(List<String> testData) {
		Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();

        for (String a : testData)
            if (!uniques.add(a))
                dups.add(a);

        // Destructive set-difference
        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
	
	/**
	 * containsAll 샘플
	 * @param testData
	 */
	public void containsAll(List<String> testData) {
		Set<String> inputSet = testData.stream().collect(Collectors.toSet());
		Set<String> targetSet1 = new HashSet<>(Arrays.asList("234", "456", "567"));
		Set<String> targetSet2 = new HashSet<>(Arrays.asList("234", "345"));
		
        System.out.println("containsAll [Target : " + targetSet1 + "] : " + inputSet.containsAll(targetSet1));
        System.out.println("containsAll [Target : " + targetSet2 + "] : " + inputSet.containsAll(targetSet2));
    }
	
	/**
	 * addAll 샘플
	 * @param testData
	 */
	public void addAll(List<String> testData) {
		Set<String> inputSet = testData.stream().collect(Collectors.toSet());
		Set<String> targetSet = new HashSet<>(Arrays.asList("234", "456", "567")); 
		
		inputSet.addAll(targetSet);
        System.out.println("addAll [Target : " + targetSet + "] : " + inputSet);
    }
	
	/**
	 * retainAll 샘플
	 * @param testData
	 */
	public void retainAll(List<String> testData) {
		Set<String> inputSet = testData.stream().collect(Collectors.toSet());
		Set<String> targetSet = new HashSet<>(Arrays.asList("234", "456", "567"));
		
		inputSet.retainAll(targetSet);
        System.out.println("retainAll [Target : " + targetSet + "] : " + inputSet);
    }
	
	/**
	 * removeAll 샘플
	 * @param testData
	 */
	public void removeAll(List<String> testData) {
		Set<String> inputSet = testData.stream().collect(Collectors.toSet());
		Set<String> targetSet = new HashSet<>(Arrays.asList("234", "456", "567")); 
		
		inputSet.removeAll(targetSet);
        System.out.println("removeAll [Target : " + targetSet + "] : " + inputSet);
    }
	
}