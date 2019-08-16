package com.ho.practice.java.collection;

public class Main {
	public static void main(String[] args) {
		args = new String[]{"123", "234", "345", "123"};
		
		SetSample ss = new SetSample();
		ss.findUniqeValue(args);
		ss.findUniqeValueAndDuplicate(args);
		ss.containsAll(args);
		ss.addAll(args);
		ss.retainAll(args);
		ss.removeAll(args);
		
    }
}
