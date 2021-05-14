package com.ho.practice.java.enm;

import java.util.Optional;

import com.ho.practice.java.enm.case3.Operation3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class Operation3Test {
    
    @Test
	public void plusTest() {
        double x = 1.0;
        double y = 2.0;
        for (Operation3 op : Operation3.values()) {
            System.out.printf("%.1f %s %.1f = %.1f%n",
            x, op, y, op.apply(x, y));
        }
	}

    @Test
	public void fromStringTest() {
        Optional<Operation3> operOptional = Operation3.fromString("+");
        operOptional.ifPresent(op -> {
            double x = 1.0;
            double y = 2.0;
            System.out.printf("%.1f %s %.1f = %.1f%n",
                x, op, y, op.apply(x, y));
        });
	}
    
}
