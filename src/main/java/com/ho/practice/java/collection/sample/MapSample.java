package com.ho.practice.java.collection.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ho.practice.java.collection.Department;
import com.ho.practice.java.collection.Employee;

/**
 * Map을 활용해보는 클래스
 *
 */
public class MapSample {
	
	public static void main(String[] args) {
		MapSample ms = new MapSample();
		ms.initMap();
		ms.byDeptEmployee();
		ms.byDeptAndGender();
		ms.byDeptSalary();
		ms.byGradePartition();
		ms.compareEachMapImple();
		ms.validate();
		ms.anagrams();
		
		/*
		 * immutable Set with the single, specified element
		 */
//		Set<String> testSet = Collections.singleton("test");
    }
	
	public void initMap() {
		Map<String, Employee> map = Stream.of(new Object[][] {
		    { "employee1", new Employee(new Department("부서1")) }
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (Employee) data[1]));
		
		System.out.println("Key : employee1 , Value : " + map.get("employee1").getDepartment().getDeptName());
	}
	
	/**
	 * 부서별로 직원 분류
	 */
	public void byDeptEmployee() {
		List<Department> departments = 
				  Arrays.asList(new Department("potatoes"),
				                new Department("orange"),
				                new Department("sugar"));
		List<Employee> employees = 
				  Arrays.asList(new Employee(departments.get(0)),
				                new Employee(departments.get(1)),
				                new Employee(departments.get(2)),
				                new Employee(departments.get(0)),
				                new Employee(departments.get(0)));
		
		// Group employees by department
		Map<Department, List<Employee>> byDept = employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment));
		
		String result = "부서별 직원 수 :";
		for (Entry<Department, List<Employee>> map : byDept.entrySet()) {
			result += " " + map.getKey().getDeptName() + " (" + map.getValue().size() + ")";
		}
		System.out.println(result);
	}
	
	/**
	 * 부서별, 직군별 직원 분류
	 */
	public void byDeptAndGender() {
		List<Department> departments = 
				  Arrays.asList(new Department("potatoes"),
				                new Department("orange"),
				                new Department("sugar"));
		List<Employee> employees = 
				  Arrays.asList(new Employee(departments.get(0), "m"),
				                new Employee(departments.get(1), "m"),
				                new Employee(departments.get(2), "m"),
				                new Employee(departments.get(0), "m"),
				                new Employee(departments.get(0), "f"));
		
		// Group employees by department
		Map<Department, Map<String, List<Employee>>> byDeptAndGender = employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender)));
		
		String result = "부서별,성별 직원 수 :";
		for (Entry<Department, Map<String, List<Employee>>> deptMap : byDeptAndGender.entrySet()) {
			result += " " + deptMap.getKey().getDeptName();
			for (Entry<String, List<Employee>> genderMap : deptMap.getValue().entrySet()) {
				result += " " + (genderMap.getKey().equals("m")?"남성":"여성") + "(" + genderMap.getValue().size() + ")";
			}
		}
		System.out.println(result);
	}
	
	/**
	 * 부서별 급여의 합
	 */
	public void byDeptSalary() {
		List<Department> departments = 
				  Arrays.asList(new Department("potatoes"),
				                new Department("orange"),
				                new Department("sugar"));
		List<Employee> employees = 
				  Arrays.asList(new Employee(departments.get(0), 100, 5),
				                new Employee(departments.get(1), 100, 4),
				                new Employee(departments.get(2), 100, 3),
				                new Employee(departments.get(0), 100, 2),
				                new Employee(departments.get(0), 100, 1));
		
		// Compute sum of salaries by department
		Map<Department, Integer> totalByDept = employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,
		Collectors.summingInt(Employee::getSalary)));
		
		String result = "부서별 급여의 합 :";
		for (Entry<Department, Integer> map : totalByDept.entrySet()) {
			result += " " + map.getKey().getDeptName() + " (" + map.getValue() + ")";
		}
		System.out.println(result);
	}
	
	/**
	 * 합격불합격 구분
	 */
	public void byGradePartition() {
		Integer PASS_THRESHOLD = 3;
		
		List<Department> departments = 
				  Arrays.asList(new Department("potatoes"),
				                new Department("orange"),
				                new Department("sugar"));
		List<Employee> employees = 
				  Arrays.asList(new Employee(departments.get(0), 100, 5),
				                new Employee(departments.get(1), 100, 4),
				                new Employee(departments.get(2), 100, 3),
				                new Employee(departments.get(0), 100, 2),
				                new Employee(departments.get(0), 100, 1));
		
		// Partition employees into passing and failing
		Map<Boolean, List<Employee>> passingFailing = employees.stream()
		.collect(Collectors.partitioningBy(s -> s.getGrade()>= PASS_THRESHOLD )); 
		
		String result = "3을 기준으로 나눔 :";
		for (Entry<Boolean, List<Employee>> map : passingFailing.entrySet()) {
			result += " " + (map.getKey()?"합격자 수 : ":"불합격자 수") + " (" + map.getValue().size() + ")";
		}
		System.out.println(result);
	}
	
	/**
	 * Map의 Implementaiton들을 비교
	 */
	public void compareEachMapImple() {
		String s = "if it is to be it is up to me to delegate";
		String[] args = s.split(" ");
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		Map<String, Integer> tm = new TreeMap<String, Integer>();
        Map<String, Integer> lm = new LinkedHashMap<String, Integer>();
        
        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
            tm.put(a, (freq == null) ? 1 : freq + 1);
            lm.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println("Input string : " + s);
        System.out.println("HashMap : " + m.size() + " distinct words:" + m);
        System.out.println("TreeMap : " + tm.size() + " distinct words:" + tm);
        System.out.println("LinkedHashMap : " + lm.size() + " distinct words:" + lm);
	}
	
	/**
	 * 유효성 확인 응용
	 */
	public void validate() {
		Map<String, String> attrMap = Stream.of(new String[][] {
			  { "1", "a" }, 
			  { "2", "b" }, 
			  { "3", "c" }, 
//			  { "5", "d" }, 
			}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
		Set<String> requiredAttrs = new HashSet<>(Arrays.asList("1", "2", "3"));
		Set<String> permittedAttrs = new HashSet<>(Arrays.asList("1", "2", "3", "4"));
		
		boolean valid = true;
	    Set<String> attrs = attrMap.keySet();

	    if (! attrs.containsAll(requiredAttrs)) {
	        Set<String> missing = new HashSet<String>(requiredAttrs);
	        missing.removeAll(attrs);
	        System.out.println("Missing attributes: " + missing);
	        valid = false;
	    }
	    if (! permittedAttrs.containsAll(attrs)) {
	        Set<String> illegal = new HashSet<String>(attrs);
	        illegal.removeAll(permittedAttrs);
	        System.out.println("Illegal attributes: " + illegal);
	        valid = false;
	    }
	    System.out.println("Is valid? " + valid);
	}
	
	/**
	 * 애너그램 예제
	 */
	public void anagrams() {
		int minGroupSize = Integer.parseInt("8");

        // Read words from file and put into a simulated multimap
        Map<String, List<String>> m = new HashMap<String, List<String>>();

        try {
            @SuppressWarnings("resource")
			Scanner s = new Scanner(new File(getClass().getClassLoader().getResource("dictionary.txt").getFile()));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null)
                    m.put(alpha, l=new ArrayList<String>());
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        // Print all permutation groups above size threshold
        for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);
	}
	
	private String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
	
}