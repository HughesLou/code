package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 若一个字符串的每个字符均为'1'，则该字符串称为完美字符串。
 * 给定一个只由'0'和'1'组成的字符串s和一个整数k。你可以对字符串进行任意次以下操作
 * <p>
 * 选择字符串的一个区间长度不超过k的区间[l, r]，将区间内的所有'0'修改成'1'，将区间内所有的'1'修改成'0'。
 * 你最少需要多少次操作，可以将字符串s修改成一个完美字符串
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class PerfectString321 implements Easy {

    /**
     * @param s: string need to be transformed
     * @param k: minimum char can be transformed in one operation
     * @return: minimum times to transform all char into '1'
     */
    public int perfectString(String s, int k) {
        int result = 0, n = s.length(), len = 0;
        if (s.charAt(0) == '0') {
            result = 1;
            len = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                if ('0' != s.charAt(i - 1)) {
                    result++;
                    len = 1;
                } else {
                    if (len == k) {
                        result++;
                        len = 1;
                    } else {
                        len++;
                    }
                }
            }
        }
        return result;
    }
}
