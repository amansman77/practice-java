package com.ho.practice.java.lambda;

import java.util.List;

import org.junit.Test;

public class PersonTest {

    @Test
	public void testPrintPersonsOlderThan() {
        List<Person> persons = List.of(
            new Person("a", 9),
            new Person("b", 10),
            new Person("c", 11),
            new Person("d", 12)
        );
        
		Person.printPersonsOlderThan(persons, 10);
	}

    @Test
	public void testPrintPersonsWithinAgeRange() {
        List<Person> persons = List.of(
            new Person("a", 9),
            new Person("b", 10),
            new Person("c", 11),
            new Person("d", 12)
        );
        
		Person.printPersonsWithinAgeRange(persons, 10, 11);
	}

    @Test
	public void testPrintPersons() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, 17),
            new Person("b", Person.Sex.MALE, 18),
            new Person("c", Person.Sex.MALE, 19),
            new Person("d", Person.Sex.FEMALE, 19)
        );
        
		Person.printPersons(persons, new CheckPersonEligibleForSelectiveService());
	}

    /**
     * Approach 4: 
     * Specify Search Criteria Code in an Anonymous Class
     * Anonymous Class를 활용함으로써 interface와 implements를 생성하지 않고 로직을 전달할 수 있게 됐습니다.
     * but, anonymous classes를 사용하면서 생기는 불필요한 코드가 있습니다.
     */
    @Test
	public void testPrintPersons_anonymous() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, 17),
            new Person("b", Person.Sex.MALE, 18),
            new Person("c", Person.Sex.MALE, 19),
            new Person("d", Person.Sex.FEMALE, 19)
        );
        
		Person.printPersons(
            persons,
            new CheckPerson(){

                @Override
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
                }
                
            }
        );
	}
    
    /**
     * Approach 5: 
     * Specify Search Criteria Code with a Lambda Expression
     * Lambda Expression을 활용함으로써 주요 로직만 작성하도록 개선됐습니다.
     * 
     * 여기서, CheckPerson interface는 functional interface 입니다. functional interface 는 하나의 abstract method 를 가지는 interface를 지칭합니다.
     * functional interface가 하나의 abstract method 를 가짐으로써 interface의 이름과 abstract method 이름을 생략 가능한 구조가 됩니다.
     */
    @Test
	public void testPrintPersons_lambda() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, 17),
            new Person("b", Person.Sex.MALE, 18),
            new Person("c", Person.Sex.MALE, 19),
            new Person("d", Person.Sex.FEMALE, 19)
        );
        
		Person.printPersons(
            persons,
            (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
	}

    @Test
	public void testPrintPersonsWithPredicate() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, 17),
            new Person("b", Person.Sex.MALE, 18),
            new Person("c", Person.Sex.MALE, 19),
            new Person("d", Person.Sex.FEMALE, 19)
        );
        
		Person.printPersonsWithPredicate(
            persons,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
	}

    @Test
	public void testProcessPersons() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, 17),
            new Person("b", Person.Sex.MALE, 18),
            new Person("c", Person.Sex.MALE, 19),
            new Person("d", Person.Sex.FEMALE, 19)
        );
        
		Person.processPersons(
            persons,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.printPerson()
       );
	}

    @Test
	public void testProcessPersonsWithFunction() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, "a@a.com", 17),
            new Person("b", Person.Sex.MALE, "b@b.com", 18),
            new Person("c", Person.Sex.MALE, "c@c.com", 19),
            new Person("d", Person.Sex.FEMALE, "d@d.com", 19)
        );
        
		Person.processPersonsWithFunction(
            persons,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );
	}

    @Test
	public void testProcessElements() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, "a@a.com", 17),
            new Person("b", Person.Sex.MALE, "b@b.com", 18),
            new Person("c", Person.Sex.MALE, "c@c.com", 19),
            new Person("d", Person.Sex.FEMALE, "d@d.com", 19)
        );
        
		Person.processElements(
            persons,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );
	}

    /**
     * Approach 9: 
     * Use Aggregate Operations That Accept Lambda Expressions as Parameters
     */
    @Test
	public void testAggregateOperations() {
        List<Person> persons = List.of(
            new Person("a", Person.Sex.MALE, "a@a.com", 17),
            new Person("b", Person.Sex.MALE, "b@b.com", 18),
            new Person("c", Person.Sex.MALE, "c@c.com", 19),
            new Person("d", Person.Sex.FEMALE, "d@d.com", 19)
        );
        
		persons
        .stream()
        .filter(
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25)
        .map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
	}
    
}
