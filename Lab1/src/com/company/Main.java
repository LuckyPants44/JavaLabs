package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {0, 2, 44, 22, 1, 15, 6, 7, 8, -32};
        System.out.println("Неотсортированный массив:");
        ShowElements(numbers);
        Arrays.sort(numbers);
        System.out.println("Отсортированный с помощью Array.sort() массив:");
        ShowElements(numbers);
        numbers = BubbleSort(numbers);
        System.out.println("Отсортированный методом пузырька массив:");
        ShowElements(numbers);
    }

    public static int[] BubbleSort(int[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    if (a[i] < a[j]) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
        return a;
    }

    public static void ShowElements(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }
}
