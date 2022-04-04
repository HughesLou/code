package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 二阶阶乘
 * <p>
 * 给定一个数n，返回该数的二阶阶乘。
 * 在数学中，正整数的二阶阶乘表示不超过这个正整数且与它有相同奇偶性的所有正整数乘积。
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class DoubleFactorial771 implements Easy {
    /**
     * @param n: the given number
     * @return: the double factorial of the number
     */
    public long doubleFactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * doubleFactorial(n - 2);
    }
}
