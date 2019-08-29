package com.ho.practice.java.collection.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ho.practice.java.collection.Employee;
import com.ho.practice.java.collection.Name;

/**
 * 정렬에 대한 예제
 *
 */
public class SortSample {
	public static void main(String[] args) {
		SortSample ss = new SortSample();
		ss.nameSort();
		ss.empSort();
    }
	
	/**
	 * 객체의 compareTo를 override하여 정렬 구현
	 */
	public void nameSort() {
		Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };

        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);
	}
	
	static final Comparator<Employee> SENIORITY_ORDER = 
		            new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e2.getHireDate().compareTo(e1.getHireDate());
		}
	};
    /**
     * Comparator를 구현하여 정렬 구현
     * @throws ParseException 
     */
	public void empSort() {
		// Employee database
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		Collection<Employee> employees = null;
		try {
			employees = Arrays.asList(new Employee(dateformat.parse("2019/03/01")),
			            new Employee(dateformat.parse("2019/10/01")),
			            new Employee(dateformat.parse("2019/01/01")),
			            new Employee(dateformat.parse("2019/08/01")),
			            new Employee(dateformat.parse("2019/05/01")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		List<Employee> e = new ArrayList<Employee>(employees);
        Collections.sort(e, SENIORITY_ORDER);
        System.out.println(e);
	}
}