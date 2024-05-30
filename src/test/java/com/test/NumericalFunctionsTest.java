package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class NumericalFunctionsTest {
private ArrayList<Integer> list;

    NumericalFunctionsTest() throws IOException {
        list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("input10.txt"));
        String[] numsArray = reader.readLine().split(" ");
        for (int i = 0; i < numsArray.length; i++) {
            list.add(Integer.parseInt(numsArray[i]));
        }
    }

    @Test
    void minTest() {
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            if (num < min) {
                min = num;
            }
        }

        assertEquals(-2, min);
    }

    @Test
    void maxTest() {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }

        assertEquals(10000, max);
    }

    @Test
    void sumTest() {
        long sum = 0;
        for (int num : list) {
            sum += num;
        }

        assertEquals(10053, sum);
    }

    @Test
    void multTest() {
        long mult = 1;
        for (int num : list) {
            mult *= num;
        }

        assertEquals(-5400000, mult);
    }

@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    @Disabled
    void timeCheck() throws InterruptedException {
        Thread.sleep(200);
    }
}
