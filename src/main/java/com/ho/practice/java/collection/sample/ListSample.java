package com.ho.practice.java.collection.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.ho.practice.java.collection.Person;

/**
 * List를 활용해보는 클래스
 *
 */
public class ListSample {
	public static void main(String[] args) {
		args = new String[]{"123", "234", "345", "123"};
		
		ListSample ls = new ListSample();
		ls.getNameList();
		ls.getPerson();
		ls.shuffle(args);
    }
	
	/**
	 * List의 Object에서 특정값을 축출하여 List생성 
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
	 * List의 Object에서 특정값을 가진 객체 반환 
	 * @param args
	 */
	public void getPerson() {
		List<Person> peopleList = 
				  Arrays.asList(new Person("potatoes"),
				                new Person("orange"),
				                new Person("lemon"),
				                new Person("bread"),
				                new Person("sugar"));
		
		Person person = peopleList.stream()
				.filter(p -> "lemon".equals(p.getName()))
				.findAny()
				.orElse(null);
		
		System.out.println("Peoples : " + person);
    }
	
	/**
	 * List내의 값들끼리 임의로 변경
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