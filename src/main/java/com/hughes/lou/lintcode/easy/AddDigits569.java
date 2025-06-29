package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class AddDigits569 implements Easy {
    /**
     * @param num: a non-negative integer
     * @return: one digit
     */
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= num;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits1(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}