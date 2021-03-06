# Java 관련 샘플 코드
본 내용은 [The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/collections/index.html)을 참고했습니다.

## 개발 프레임워크
- IDE : STS-4.2.2.RELEASE
- Java : openjdk-12.0.1
- JUnit : 4

## Collection

![Collection의 인터페이스 구조도](https://docs.oracle.com/javase/tutorial/figures/collections/colls-coreInterfaces.gif)

최상위 부모 인터페이스

### 제공 함수
- int size()
- boolean isEmpty()
- boolean contains(Object element)
- boolean add(E element)
- boolean remove(Object element)
- Iterator<E> iterator()
- boolean containsAll(Collection<?> c)
- boolean addAll(Collection<? extends E> c)
- boolean removeAll(Collection<?> c)
- boolean retainAll(Collection<?> c)
- void clear()

### JDK 8 이후부터 stream 함수가 있음
- myShapesCollection.stream()
.filter(e -> e.getColor() == Color.RED)
.forEach(e -> System.out.println(e.getName()));
- myShapesCollection.parallelStream()
.filter(e -> e.getColor() == Color.RED)
.forEach(e -> System.out.println(e.getName()));

## Set

중복값을 허용하지 않는 collection

Implementation : HashSet, TreeSet, LinkedHashSet

- HashSet
    - Hash table에 element 저장
    - 성능이 가장 좋음
    - 순서를 보장하지 않음
- TreeSet
    - Red-Black tree(balanced binary search tree)에 element 저장
    - 값를 기준으로 정렬됨
    - HashSet보다 느림
- LinkedHashSet
    - linked list로 구성된 hash table을 가짐
    - 입력 순서를 보장
    - HashSet보다 조금 느림

### Bulk Operations

- s1.containsAll(s2) — s2가 s1의 subset이면 true반환. (s1이 s2의 모든 element를 포함하면 s2는 s1의 subset이다.)
- s1.addAll(s2) — s1에 s2를 union한다.
- s1.retainAll(s2) — s1에 s2를 intersection한다.
- s1.removeAll(s2) — s1에서 s2의 element를 제거한다.

### 집합처리

[Java의 두 Set 교집합 최적화 - The Missing Papers](http://docs.likejazz.com/intersection-of-two-sets/)를 참고했습니다.

집합처리를 하는 방식에는 JDK, Guava, NIH 가 있는데, 성능은 NIH > Guava > JDK 순서로 좋다.

*교집합*

JDK 활용
```java
Set<Integer> intersection = new HashSet<Integer>(preSet);
intersection.retainAll(curSet);
intersectionSize = intersection.size();
```

Guava 활용
```java
Set<Integer> intersection = Sets.intersection(curSet, preSet);
intersectionSize = intersection.size();
```

*차집합*

Guava 활용
```java
Set<Integer> difference = Sets.difference(oldIdSet, newIdSet)
```

## SortedSet
순서를 가지는 Set

함수 그룹 : Range View, Endpoints, Comparator access

TreeSet과 동일한 기능??
- SortedSet은 인터페이스이고 TreeSet이 implementing하여 사용함

## List (Sequence)
순서를 보장하는 collection

다음 기능을 활용할 수 있음
- Positional access
- Search 
- Iteration
- Range view

Implementation : ArrayList, LinkedList
- ArrayList : 성능이 가장 좋음
- LinkedList : 특정 상황에서 좋은 성능을 제공

List만을 위한 함수
- sort — sorts a List using a merge sort algorithm, which provides a fast, stable sort. (A stable sort is one that does not reorder equal elements.)
- shuffle — randomly permutes the elements in a List.
- reverse — reverses the order of the elements in a List.
- rotate — rotates all the elements in a List by a specified distance.
- swap — swaps the elements at specified positions in a List.
- replaceAll — replaces all occurrences of one specified value with another.
- fill — overwrites every element in a List with the specified value.
- copy — copies the source List into the destination List.
- binarySearch — searches for an element in an ordered List using the binary search algorithm.
- indexOfSubList — returns the index of the first sublist of one List that is equal to another.
- lastIndexOfSubList — returns the index of the last sublist of one List that is equal to another.

## Queue
데이터를 처리하기전에 보관하기위한 collection

일반적으로 FIFO

## Deque
head와 tail에서 element의 수정가능한 collection

Stack이나 Queue보다 무겁다.

FIFO, LIFO

Implementation : ArrayDeque, LinkedList

## Map
Key-Value를 세트로 가지는 collection

제공 함수
- put, get, containsKey, containsValue, size, empty
- Bulk operation : putAll, clear
- collections views : keySet, entrySet, values

## SortedMap
Key가 순서를 가지는 Map

## 샘플

`com.ho.practice.java.collection.sample` 패키지에 구현

### Set
- Unique value 추출
- Value 중 1개만 있는 것과 중복을 가지는 값 분류
- containsAll, addAll, retainAll, removeAll 활용 샘플
### List
- 객체를 가진 리스트에서 특정값만 추출하여 리스트로 재구성
- 리스트내의 임의의 값을 섞음
### Map
- 부서별 직원분류
- 부서별, 직군별 직원분류
- 부서별 급여 총합
- 합격/불합격 구분
- Map의 Implementaiton들을 비교
- 유효성 확인 예제
- 애너그램 예제
### Sort
- 객체의 compareTo를 override하여 정렬
- Comparator를 구현하여 정렬





## Util

`com.ho.practice.java.util` 패키지에 구현

### Date

[Java의 날짜와 시간 API - Naver D2](https://d2.naver.com/helloworld/645609)를 참고함





## Compare

`com.ho.practice.java.compare` 패키지에 구현




## JUnit

도입

## File Watch

`java.nio.file.WatchService`를 활용하여 파일의 변경사항을 감지하는 예제 추가

`com.ho.practice.java.file`에 구현

## Troubleshooting

### JUnit 구동시 `NoClassDefFoundError`발생

```java
java.lang.NoClassDefFoundError: org/junit/runner/manipulation/Filter
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:332)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.loadTestLoaderClass(RemoteTestRunner.java:381)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.createRawTestLoader(RemoteTestRunner.java:371)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.createLoader(RemoteTestRunner.java:366)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.defaultInit(RemoteTestRunner.java:310)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.init(RemoteTestRunner.java:225)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:209)
Caused by: java.lang.ClassNotFoundException: org.junit.runner.manipulation.Filter
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
	... 8 more
```

#### 실제 라이브러리가 없는지에 대한 확인

다음 과정으로 JUnit 4 라이브러리를 추가한 상태임
`Java Build Path -> Libraries -> Add Library -> JUnit 4`

이는 STS에서 제공하는 JUnit 플러그인을 사용하겠다는 의미이고 `JUnit-4.12`와 `hamcrest.core-1.3.0`을 지원하고 있음

`JUnit.jar`에 `org.junit.runner.manipulation.Filter`클래스 존재

**클래스가 존재하는것을 확인했습니다.**

#### 테스트하는 과정에서 라이브러리가 누락되는지 확인

JUnit을 실행하기 위한 명령어를 확인하니 다음과 같다.
```bash
C:\ho\dev\Java\x64\jdk-12.0.1\bin\javaw.exe
 -ea
 -Dfile.encoding=UTF-8
 -p "C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\plugins\org.junit_4.12.0.v201504281640\junit.jar;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\plugins\org.hamcrest.core_1.3.0.v20180420-1519.jar"
 -classpath "C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\workspace\practice-java\bin\main;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\workspace\practice-java\bin\test;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\workspace\practice-java\bin\default;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\configuration\org.eclipse.osgi\823\0\.cp;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\configuration\org.eclipse.osgi\822\0\.cp"
 org.eclipse.jdt.internal.junit.runner.RemoteTestRunner
 -version 3
 -port 3064
 -testLoaderClass org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader
 -loaderpluginname org.eclipse.jdt.junit4.runtime
 -test com.ho.practice.java.util.DateUtilTest:getNowTest
```

보면 `junit.jar`가 모듈로 설정되어 있는것을 확인할 수 있습니다.

이를 `Java Build Path`에서 `Classpath`로 변경했더니 다음과 같이 `classpath`에 `junit.jar`가 들어간것을 확인할 수 있습니다.
```bash
C:\ho\dev\Java\x64\jdk-12.0.1\bin\javaw.exe
 -ea
 -Dfile.encoding=UTF-8
 -classpath "C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\workspace\practice-java\bin\main;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\workspace\practice-java\bin\test;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\workspace\practice-java\bin\default;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\plugins\org.junit_4.12.0.v201504281640\junit.jar;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\plugins\org.hamcrest.core_1.3.0.v20180420-1519.jar;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\configuration\org.eclipse.osgi\823\0\.cp;C:\ho\dev\IDE\spring-tool-suite-4-4.2.2.RELEASE-e4.11.0-win32.win32.x86_64\sts-4.2.2.RELEASE\configuration\org.eclipse.osgi\822\0\.cp"
 org.eclipse.jdt.internal.junit.runner.RemoteTestRunner
 -version 3
 -port 5993
 -testLoaderClass org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader
 -loaderpluginname org.eclipse.jdt.junit4.runtime
 -test com.ho.practice.java.util.DateUtilTest:getNowTest
```

**이렇게 설정을 변경하고 JUnit 테스트를 수행하니 잘 수행됩니다.**