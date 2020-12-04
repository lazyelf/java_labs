package com.company;
import java.util.Scanner;

/**
 * Клас генерує на основі класу Interval перші два числа ряду Фібоначчі таким чином:
 * першим числом буде найбільше непарне число, другим – найбільше парне число інтервалу.
 * На екран виводяться згенеровані наступні елементи ряду.
 * Довжину ряду користувач вводить з клавіатури.
 * */

public class FibonacciSeries {
    int first;
    int second;
    int odd_counter = 1;
    int amount;

    /**
     * Конструктор приймає як агрумент об'єкт класу Interval
     * через дані переданого класу генерує перші два числа ряду Фібоначчі
     * */

    FibonacciSeries(Interval object) {
        System.out.print("Please, enter length of fibonacci series: ");
        setAmount();
        first = (int)(object.getRight());
        if (isOdd(first)) {
            second = first - 1;
        }
        else {
            second = first;
            --first;
        }
    }

    private boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    private void setAmount() {
        Scanner in = new Scanner(System.in);
        amount = in.nextInt();
    }

    /**
     * Метод друкує ряд Фібоначчі;
     * рахує і виводить на екран відсоткове співвідношення парних і непарних чисел у ряді
     * */

    public void printSeries() {
        System.out.print(first + " " + second + " ");
        for (int i = 2; i < amount; ++i) {
            int temp = first + second;
            if (isOdd(temp)) {
                ++odd_counter;
            }
            System.out.print(temp + " ");
            first = second;
            second = temp;
        }
        double temp = (double)(odd_counter * 100) / amount;
        System.out.print("\nPercent of odd numbers: " + temp + "%\nPercent of even numbers: " + (100 - temp) + "%");

    }
}
