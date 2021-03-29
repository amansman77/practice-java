package com.ho.practice.java.lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    Integer age;

    public Person() {}
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person(String name, Sex gender, String emailAddress, int age) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.println("name: " + name + ", age: " + age);
    }



    
    /**
     * Approach 1:
     * Create Methods That Search for Members That Match One Characteristic
     * but, age보다 어린 사람을 검색하고 싶은 경우가 생기면 
     * 새로운 함수를 추가하여 검색 조건에 따라 함수가 나뉘거나
     * 기존 함수의 변경에 따른 추가 공수가 생길것입니다.
     * 
     * @param roster
     * @param age
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * Approach 2:
     * Create More Generalized Search Methods
     * but, 다른 속성과 혼합하여 검색하고 싶은 경우에 
     * 새로운 함수를 추가하여 검색 조건에 따라 함수가 나뉘거나
     * 기존 함수의 변경에 따른 추가 공수가 생길것입니다.
     * 
     * @param roster
     * @param low
     * @param high
     */
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    /**
     * Approach 3:
     * Specify Search Criteria Code in a Class
     * 검색 조건의 변경이나 Person 클래스의 변경에도 변하지 않는 인터페이스는 달성을 했습니다.
     * but, 검색 조건의 구현을 위해 interface와 implements를 생성해야하는 불편함이 남아있습니다.
     * 
     * @param roster
     * @param tester
     */
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }





    /**
     * Approach 6: 
     * Use Standard Functional Interfaces with Lambda Expressions
     * CheckPerson interface 는 매우 간단한 형식을 가지는데 모든 객체와 맵핑하여 생성하는것을 비효율적입니다.
     * 따라서 JDK 는 몇몇 표준적인 functional interfaces 를 java.util.function 패키지에 제공합니다.
     * 
     * @param roster
     * @param tester
     */
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * Approach 7.1: 
     * Use Lambda Expressions Throughout Your Application
     * printPerson() 의 로직도 함수의 사용시점에 정의하고 싶다면 lambda expressions 을 활용할 수 있습니다.
     * 다만, 새로운 유형의 functional interfaces 가 필요합니다.(하나의 argument 를 받고 void 를 반환하는 형태)
     * JDK 에서 제공하는 Consumer<T> interface 에 accept() 함수가 동일한 형식을 가지고 있어 이를 활용할 수 있습니다.
     * 
     * @param roster
     * @param tester
     * @param block
     */
    public static void processPersons(
        List<Person> roster,
        Predicate<Person> tester,
        Consumer<Person> block) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    block.accept(p);
                }
            }
    }

    /**
     * Approach 7.2: 
     * 하나의 argument 를 받고 value 를 반환하는 형태를 사용하고 싶으면, Function<T,R> interface 의 `R apply(T t)` 을 사용하면 됩니다.
     * 
     * @param roster
     * @param tester
     * @param mapper
     * @param block
     */
    public static void processPersonsWithFunction(
        List<Person> roster,
        Predicate<Person> tester,
        Function<Person, String> mapper,
        Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    /**
     * Approach 8: 
     * Use Generics More Extensively
     * 
     * @param <X>
     * @param <Y>
     * @param source
     * @param tester
     * @param mapper
     * @param block
     */
    public static <X, Y> void processElements(
        Iterable<X> source,
        Predicate<X> tester,
        Function <X, Y> mapper,
        Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}
