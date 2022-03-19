package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * 反转一个只有3位数的整数。
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class Reverse3DigitInteger37 implements Naive {

    public int reverse(int number) {
        int n0 = number % 10;
        int n1 = (number / 10) % 10;
        int n2 = number / 100;
        return n0 * 100 + n1 * 10 + n2;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        Reverse3DigitInteger37 reverse3DigitInteger37 = new Reverse3DigitInteger37();
        System.out.println(reverse3DigitInteger37.reverse(a));
    }
}