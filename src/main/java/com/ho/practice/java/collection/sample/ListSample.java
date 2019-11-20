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
		
		List<Person> people = Arrays.asList(new Person("potatoes", "m", 10),
                new Person("orange", "m", 20),
                new Person("lemon", "m", 30),
                new Person("bread", "w", 10),
                new Person("sugar", "w", 20));
		
		System.out.println("Test data : " + people);
		ListSample ls = new ListSample();
		ls.listToCSV(people);
		ls.getNameList(people);
		ls.findMan(people);
		ls.findPerson(people);
		ls.sumAge(people);
		ls.shuffle(args);
    }
	
	/**
	 * 나이의 합
	 * @param people
	 */
	private void sumAge(List<Person> people) {
		System.out.println(
				"Sum age : " +
				people.stream().collect(Collectors.summingInt(Person::getAge)));
	}

	/**
	 * 성별이 남자인 사람만 추출
	 * @param people
	 */
	private void findMan(List<Person> people) {
		System.out.println("Find Man : " + people.stream().filter(p -> p.getGender().equals("m")).collect(Collectors.toList()));
	}

	/**
	 * List의 특정 필드를 CSV로 변환하는 예제
	 * @param people 
	 */
	private void listToCSV(List<Person> people) {
		System.out.println("Name CSV : " + people.stream().map(Person::getName).collect(Collectors.joining(",")));
	}

	/**
	 * List의 Object에서 특정값을 축출하여 List생성 
	 * @param people2 
	 * @param args
	 */
	public void getNameList(List<Person> people) {
		List<String> list = people.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		
		System.out.println("Name list : " + list);
    }
	
	/**
	 * List의 Object에서 특정값을 가진 객체 반환 
	 * @param people 
	 * @param args
	 */
	public void findPerson(List<Person> people) {
		Person person = people.stream()
				.filter(p -> "lemon".equals(p.getName()))
				.findAny()
				.orElse(null);
		
		System.out.println("Find lemin : " + person);
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