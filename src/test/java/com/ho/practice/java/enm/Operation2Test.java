package com.ho.practice.java.enm;

import static org.junit.Assert.assertEquals;

import com.ho.practice.java.enm.case3.Operation2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class Operation2Test {
    
    @Test
	public void plusTest() {
        assertEquals(3, Operation2.PLUS.apply(1, 2), 0);
	}
    
}