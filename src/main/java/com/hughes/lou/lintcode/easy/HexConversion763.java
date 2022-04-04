package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个十进制数 n 和 一个整数 k, 将 十进制数 n 转换成 k进制数.
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class HexConversion763 implements Easy {
    /**
     * @param n: a decimal number
     * @param k: a Integer represent base-k
     * @return: a base-k number
     */
    public String hexConversion(int n, int k) {
        if (n == 0) {
            return "0";
        }
        // 还需考虑 k>9 的情况
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int val = n % k;
            // 注意：这里一个表达式中的类型需要一致，这里统一转成char
            stringBuilder.insert(0, val > 9 ? (char) ('A' + val - 10) : (char) ('0' + val));
            n /= k;
        }
        return stringBuilder.toString();
    }
}
