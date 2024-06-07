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
private ArrayList<Integer> numsArray;

    // Определение тестовых данных в конструкторе класса
    NumericalFunctionsTest() throws IOException {
        numsArray = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("input10.txt"));
        String[] stringNumsArray = reader.readLine().split(" ");
        for (String strNum : stringNumsArray) {
            try {
                numsArray.add(Integer.parseInt(strNum));
            } catch (NumberFormatException e) {
                System.err.println("Файл содержит символ, который нельзя преобразовать в целое число типа int: " + strNum);
                throw e;
            }
        }
    }

    @Test
    void minTest() {
        assertEquals(-2, NumericalFunctions.min(numsArray));
    }

    @Test
    void maxTest() {
        assertEquals(10000, NumericalFunctions.max(numsArray));
    }

    @Test
    void sumTest() {
        assertAll("Sum function tests",
                () -> assertEquals(10053, NumericalFunctions.sum(numsArray)),
                () -> assertThrows(ArithmeticException.class,
                        () -> NumericalFunctions.sum(numsArray))
        );
    }

    @Test
    void multTest() {
        assertAll("Mult function tests",
                () -> assertEquals(-5400000, NumericalFunctions.mult(numsArray)),
                () -> assertThrows(ArithmeticException.class,
                        () -> NumericalFunctions.mult(numsArray))
        );
    }

    // Падающий тест
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Disabled
    void timeCheck() throws InterruptedException {
        Thread.sleep(200);
    }
}
