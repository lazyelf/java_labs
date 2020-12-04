package com.company;
import java.util.Scanner;

/**
 * Клас для збереження введених меж інтервалу та наступної обрабки їх значень:
 * виведення на екран непарних чисел за зростанням і парних чисел за спаданням;
 * знаходження і виведення сум парних і непарних чисел відповідно.
 * */

public class Interval {

    double left;
    double right;
    int sum_odd;
    int sum_even;

    public double getRight() {
        return right;
    }

    private void setLeft() {
        Scanner in = new Scanner(System.in);
        left = in.nextDouble();
    }
    private void setRight() {
        Scanner in = new Scanner(System.in);
        right = in.nextDouble();
    }
    private boolean checkInterval() {
        if (right < left) {
            double tmp = right;
            right = left;
            left = tmp;
        }
        if (right - left < 1) {
            System.out.println("Enter another interval.");
            return true;
        }
        return false;
    }
    private boolean isEven(int number) {
        return (number & 1) != 1;
    }

    /**
     * Метод дозволяє користувачеві з клавіатури задати межі інтевалу.
     * */

    public void setInterval() {
        do {
            System.out.print("Please, enter left border: ");
            setLeft();
            System.out.print("Please, enter right border: ");
            setRight();
        }
        while (checkInterval());
    }

    /**
     * Метод друкує непарні числа з інтервалу
     * в порядку зростання;
     * рахує суму непарних чисел ряду.
     * */

    public void printOdd() {
        int begin = (int)left;
        if (isEven(begin)) {
            ++begin;
        }
        if(begin < left) {
            begin += 2;
        }
       for(; begin <= right; begin += 2) {
           System.out.print(begin + " ");
           sum_odd += begin;
       }
       System.out.print("\n");
    }

    /**
     * Метод друкує парні числа з інтервалу
     * в порядку спадання;
     * рахує суму парних чисел ряду.
     * */

    public void printEven() {
        int begin = (int)right;
        if (!isEven(begin)) {
            --begin;
        }
        for(; begin >= left; begin -= 2) {
            System.out.print(begin + " ");
            sum_even += begin;
        }
        System.out.print("\n");
    }

    /**
     * Метод друкує суму непарних чисел, якщо вона порахована.
     * Якщо не порахована викликає метод printOdd(), а опісля друкує.
     * */

    public void printSumOdd() {
        if (sum_odd == 0) {
            System.out.println("Odd numbers:");
            printOdd();
        }
        System.out.println("Sum of odd numbers:" + sum_odd);
    }

    /**
     * Метод друкує суму парних чисел, якщо вона порахована.
     * Якщо не порахована викликає метод printEven(), а опісля друкує.
     * */

    public void printSumEven() {
        if (sum_even == 0) {
            System.out.println("Even numbers:");
            printEven();
        }
        System.out.println("Sum of even numbers:" + sum_even);
    }
}

