package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
 * <p>
 * 该数字按照数位高低进行排列，最高位的数在列表的最前面。
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class PlusOne407 implements Easy {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        int extra = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + extra;
            digits[i] = sum % 10;
            extra = sum / 10;
            if (extra == 0) {
                break;
            }
        }
        if (extra == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
}
