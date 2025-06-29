package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 将一个整数中的数字进行颠倒，当颠倒后的整数溢出 32 位整数的范围 时，返回 0 。
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class ReverseInteger413 implements Easy {

    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        int result = 0;

        while (n != 0) {
            int temp = result * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != result) {
                result = 0;
                break;
            }
            result = temp;
        }
        return result;
    }

    public int reverseInteger1(int n) {
        long result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int) result;
    }
}
