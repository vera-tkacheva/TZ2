package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
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
        BigInteger result = BigInteger.valueOf(NumericalFunctions.sum(numsArray));
        if (result.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 ||
                result.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
            assertThrows(ArithmeticException.class, () -> {
                throw new ArithmeticException("Сумма не вмещается в тип long");
            });
        } else {
            assertEquals(10053, NumericalFunctions.sum(numsArray));
        }

    }

    @Test
    void multTest() {
        BigInteger result = BigInteger.valueOf(NumericalFunctions.mult(numsArray));
        if (result.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 ||
                result.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
            assertThrows(ArithmeticException.class, () -> {
                throw new ArithmeticException("Произведение не вмещается в тип long");
            });
        } else {
            assertEquals(-540000, NumericalFunctions.mult(numsArray));
        }
    }

// Падающий тест
@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    @Disabled
    void timeCheck() throws InterruptedException {
        Thread.sleep(200);
    }
}
