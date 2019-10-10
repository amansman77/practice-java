# Java 관련 샘플 코드
본 내용은 [The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/collections/index.html)을 참고했습니다.

## 개발 프레임워크
- IDE : STS-4.2.2.RELEASE
- Java : openjdk 12.0.1

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

## SortedSet
순서를 가지는 Set

함수 그룹 : Range View, Endpoints, Comparator access

TreeSet과 동일한 기능??
- SortedSet은 인터페이스이고 TreeSet이 implementing하여 사용함

## List (Sequence)
순서를 보장하는 collection

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