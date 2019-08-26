package com.ho.practice.java.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Set�� Ȱ���غ��� Ŭ����
 *
 */
public class SetSample {
	/**
	 * input value �� ������ ���� ����ϴ� �Լ�
	 * @param args
	 */
	public void findUniqeValue(String[] args) {
		Set<String> distinctWords = Arrays.asList(args).stream()
		.collect(Collectors.toSet()); 
        System.out.println(distinctWords.size()+ 
                           " distinct words: " + 
                           distinctWords);
    }
	
	/**
	 * input value �� 1���� �ִ� ���� �� �̻��� ������ �� �з� �ϴ� �Լ�
	 * @param args
	 */
	public void findUniqeValueAndDuplicate(String[] args) {
		Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();

        for (String a : args)
            if (!uniques.add(a))
                dups.add(a);

        // Destructive set-difference
        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
	
	/**
	 * containsAll ����
	 * @param args
	 */
	public void containsAll(String[] args) {
		String[] target = new String[]{"234", "456", "567"};
		
		Set<String> inputSet = Arrays.asList(args).stream()
				.collect(Collectors.toSet());
		Set<String> targetSet = Arrays.asList(target).stream()
				.collect(Collectors.toSet()); 
		
        System.out.println("containsAll : " + inputSet.containsAll(targetSet));
    }
	
	/**
	 * addAll ����
	 * @param args
	 */
	public void addAll(String[] args) {
		String[] target = new String[]{"234", "456", "567"};
		
		Set<String> inputSet = Arrays.asList(args).stream()
				.collect(Collectors.toSet());
		Set<String> targetSet = Arrays.asList(target).stream()
				.collect(Collectors.toSet()); 
		
		inputSet.addAll(targetSet);
        System.out.println("addAll : " + inputSet);
    }
	
	/**
	 * retainAll ����
	 * @param args
	 */
	public void retainAll(String[] args) {
		String[] target = new String[]{"234", "456", "567"};
		
		Set<String> inputSet = Arrays.asList(args).stream()
				.collect(Collectors.toSet());
		Set<String> targetSet = Arrays.asList(target).stream()
				.collect(Collectors.toSet()); 
		
		inputSet.retainAll(targetSet);
        System.out.println("retainAll : " + inputSet);
    }
	
	/**
	 * removeAll ����
	 * @param args
	 */
	public void removeAll(String[] args) {
		String[] target = new String[]{"234", "456", "567"};
		
		Set<String> inputSet = Arrays.asList(args).stream()
				.collect(Collectors.toSet());
		Set<String> targetSet = Arrays.asList(target).stream()
				.collect(Collectors.toSet()); 
		
		inputSet.removeAll(targetSet);
        System.out.println("removeAll : " + inputSet);
    }
	
}
