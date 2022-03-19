package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * Created by Hughes on 2016/8/14.
 */
public class Fibonacci366 implements Naive {

    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n <= 2) {
            return n - 1;
        }
        //return fibonacci(n - 2) + fibonacci(n - 1);
        int n1 = 0;
        int n2 = 1;
        int sn = 0;
        for (int i = 0; i < n - 2; i++) {
            sn = n1 + n2;
            n1 = n2;
            n2 = sn;
        }
        return sn;
    }

    public int fibonacci0(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n <= 2) {
            return n - 1;
        }

        return fibonacci0(n - 1) + fibonacci0(n - 2);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        Fibonacci366 fibonacci366 = new Fibonacci366();
        long t0 = System.currentTimeMillis();
        System.out.println(fibonacci366.fibonacci(a));
        System.out.println(System.currentTimeMillis() - t0);

        t0 = System.currentTimeMillis();
        System.out.println(fibonacci366.fibonacci0(a));
        System.out.println(System.currentTimeMillis() - t0);
    }
}