package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给两个数字，数字 a 跟数字 b。找到两者的最大公约数。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class GreatestCommonDivisor845 implements Easy {
    /**
     * 更相减损术，将两数辗转相减直至减数和余数相等，O(max(a, b))
     *
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        if (a == b) {
            return a;
        } else if (b < a) {
            return gcd(a - b, b);
        } else {
            return gcd(b - a, a);
        }
    }

    public int gcd1(int a, int b) {
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
