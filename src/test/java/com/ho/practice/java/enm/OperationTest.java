package com.ho.practice.java.enm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class OperationTest {
    
    @Test
	public void plusTest() {
        assertEquals(3, Operation.PLUS.apply(1, 2), 0);
	}
    
}
