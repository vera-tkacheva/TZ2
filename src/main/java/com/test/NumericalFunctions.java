package com.test;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NumericalFunctions {
    public static void main(String[] args) throws IOException {

        // Считывание чисел из файла
        BufferedReader reader = new BufferedReader(new FileReader("input10.txt"));
        ArrayList<Integer> numsArray = new ArrayList<>();
        String[] stringNumsArray = reader.readLine().split(" ");

        // Обработка чисел из файла (перевод в числовое значение)
        for (int i = 0; i < stringNumsArray.length; i++) {
            numsArray.add(Integer.parseInt(stringNumsArray[i]));
        }

        // Вызов функций
        int min = min(numsArray);
        int max = max(numsArray);
        long sum = sum(numsArray);
        long mult = mult(numsArray);

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + mult);

    }

    public static int min(ArrayList<Integer> numsArray) {
        int min = Integer.MAX_VALUE;
        for (int num : numsArray) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int max(ArrayList<Integer> numsArray) {
        int max = Integer.MIN_VALUE;
        for (int num : numsArray) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static long sum(ArrayList<Integer> numsArray) {
        int sum = 0;
        for (int num : numsArray) {
            sum += num;
        }
        return sum;
    }

    public static long mult(ArrayList<Integer> numsArray) {
        int mult = 1;
        for (int num : numsArray) {
            mult *= num;
        }
        return mult;
    }
}