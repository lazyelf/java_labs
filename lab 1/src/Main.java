package com.company;

public class Main {
    public static void main(String[] args) {
        if(args.length < 3)
            return;
        for(int i = 0; i < 3; ++i) {
            System.out.println(args[i]);
        }
    }
}
