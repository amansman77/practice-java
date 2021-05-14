package com.ho.practice.java.enm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AppleTest {
    
    @Test
	public void test() {
        for (Apple apple : Apple.values()) {
            System.out.println("[" + apple.ordinal() + "] apple name: " + apple.name());
            System.out.println("apple to string: " + apple.toString());
        }
	}
    
}
