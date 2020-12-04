package com.company;

/**
 * Програма запитує у користувача межі інтервала,
 * що можуть бути дійсними або цілочисловими значеннями.
 * Програма виводить на екран непарні числа з інтервалу за зростанням і парні числа за спаданням.
 * Програма виводить на екран суму непарних та парних чисел.
 *
 * Опісля програма запитує кількість довжину ряду Фібоначчі.
 * Програма будує ряд Фібоначчі: першим числом буде найбільше непарне число, другим – найбільше парне число.
 * Програма виводить відсоток непарних і парних чисел Фібоначчі.
 * @author _lazyelf
 * */


public class Main {

    public static void main(String[] args) {
        Interval object = new Interval();
        object.setInterval();
        object.printSumOdd();
        object.printSumEven();

        FibonacciSeries series = new FibonacciSeries(object);
        series.printSeries();
    }
}