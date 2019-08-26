package com.ho.practice.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * List�� Ȱ���غ��� Ŭ����
 *
 */
public class ListSample {
	/**
	 * List�� Object���� Ư������ �����Ͽ� List���� 
	 * @param args
	 */
	public void getNameList() {
		List<Person> people = 
				  Arrays.asList(new Person("potatoes"),
				                new Person("orange"),
				                new Person("lemon"),
				                new Person("bread"),
				                new Person("sugar"));
		
		List<String> list = people.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		
		System.out.println("Peoples : " + list);
    }
	
	/**
	 * List���� ���鳢�� ���Ƿ� ����
	 * @param args
	 */
	public void shuffle(String[] args) {
		List<String> list = new ArrayList<String>();
        for (String a : args)
            list.add(a);
        Collections.shuffle(list, new Random());
        System.out.println("Shuffle list : " + list);
        
        /*
         * this program can be made even shorter and faster than above one.
         * The Arrays class has a static factory method called asList,
         * which allows an array to be viewed as a List
         */
        List<String> staticList = Arrays.asList(args);
        Collections.shuffle(staticList);
        System.out.println("Shuffle static list : " + staticList);
    }
	
}
