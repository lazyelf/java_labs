package com.lazyelf;

public class Rand {
    static public int rand(int begin, int end) {
        int rand;
        do {
            rand = (int) (Math.random() * end + 0.5);
        } while (rand < begin);
        return rand;
    }
}
