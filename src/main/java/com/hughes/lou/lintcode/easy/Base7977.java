package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-06
 */
public class Base7977 implements Easy {
    /**
     * @param num: the given number
     * @return: The base 7 string representation
     */
    public String convertToBase7(int num) {
        StringBuilder result = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        while (num > 0) {
            result.insert(0, num % 7);
            num /= 7;
        }
        if (negative) {
            result.insert(0, "-");
        }
        return result.toString();
    }
}
