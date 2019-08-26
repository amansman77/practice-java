package com.ho.practice.java.collection;

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

/**
 * Map�� Ȱ���غ��� Ŭ����
 *
 */
public class MapSample {
	
	public static void main(String[] args) {
		MapSample ms = new MapSample();
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
	
	/**
	 * �μ����� ���� �з�
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
		
		String result = "�μ��� ���� �� :";
		for (Entry<Department, List<Employee>> map : byDept.entrySet()) {
			result += " " + map.getKey().getDeptName() + " (" + map.getValue().size() + ")";
		}
		System.out.println(result);
	}
	
	/**
	 * �μ���, ������ ���� �з�
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
		
		String result = "�μ���,���� ���� �� :";
		for (Entry<Department, Map<String, List<Employee>>> deptMap : byDeptAndGender.entrySet()) {
			result += " " + deptMap.getKey().getDeptName();
			for (Entry<String, List<Employee>> genderMap : deptMap.getValue().entrySet()) {
				result += " " + (genderMap.getKey().equals("m")?"����":"����") + "(" + genderMap.getValue().size() + ")";
			}
		}
		System.out.println(result);
	}
	
	/**
	 * �μ��� �޿��� ��
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
		
		String result = "�μ��� �޿��� �� :";
		for (Entry<Department, Integer> map : totalByDept.entrySet()) {
			result += " " + map.getKey().getDeptName() + " (" + map.getValue() + ")";
		}
		System.out.println(result);
	}
	
	/**
	 * �հݺ��հ� ����
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
		
		String result = "3�� �������� ���� :";
		for (Entry<Boolean, List<Employee>> map : passingFailing.entrySet()) {
			result += " " + (map.getKey()?"�հ��� �� : ":"���հ��� ��") + " (" + map.getValue().size() + ")";
		}
		System.out.println(result);
	}
	
	/**
	 * Map�� Implementaiton���� ��
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
	 * ��ȿ�� Ȯ�� ����
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
	 * �ֳʱ׷� ����
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
