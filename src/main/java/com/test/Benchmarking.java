package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Benchmarking {

    private static ArrayList<Long> numsArray;

    public static void main(String[] args) {

        String[] tests = {"input10.txt", "input50.txt", "input100.txt", "input500.txt", "input1000.txt", "input2000.txt",
                "input5000.txt", "input10000.txt", "input15000.txt", "input20000.txt"};
        String[] stringNumsArray = null;
        int len = 0;

        // Запуск методов для каждого тестирующего файла
        for (int i = tests.length - 1; i >= 0; i--) {
            try (BufferedReader reader = new BufferedReader(new FileReader(tests[i]))) {
                stringNumsArray = reader.readLine().split(" ");
                len = stringNumsArray.length;
                Benchmarking benchmarking = new Benchmarking();
                System.out.println("Время для файла " + tests[i]);
                System.out.println("Время работы min: " + benchmarking.minTime());
                System.out.println("Время работы max: " + benchmarking.maxTime());
                System.out.println("Время работы sum: " + benchmarking.sumTime());
                System.out.println("Время работы mult: " + benchmarking.multTime());
                System.out.println();
            } catch (FileNotFoundException e) {
                System.err.println("Файл не найден: " + tests[i]); // Если файл с таким названием не существует
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + tests[i]); // Если файл пустой
                e.printStackTrace();
            }
        }

        numsArray = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            numsArray.add(Long.parseLong(stringNumsArray[i]));
        }
    }

    Benchmarking() {
        numsArray = new ArrayList<>();
    }

    public long minTime() {
        long t1 = System.nanoTime();
        NumericalFunctions.min(numsArray);
        long t2 = System.nanoTime();
        return (t2 - t1);
    }

    public long maxTime() {
        long t1 = System.nanoTime();
        NumericalFunctions.max(numsArray);
        long t2 = System.nanoTime();
        return (t2 - t1);
    }

    public long sumTime() {
        long t1 = System.nanoTime();
        NumericalFunctions.sum(numsArray);
        long t2 = System.nanoTime();
        return (t2 - t1);
    }

    public long multTime() {
        long t1 = System.nanoTime();
        NumericalFunctions.mult(numsArray);
        long t2 = System.nanoTime();
        return (t2 - t1);
    }
}
