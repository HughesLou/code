/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by Hughes on 2018/1/20 19:50.
 */
public class BigIntegerAddition655 implements Easy {

    /*
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        String result = "";
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            carry = sum / 10;
            sum = sum % 10;
            result = String.valueOf(sum).concat(result);
        }

        if (carry > 0) {
            result = String.valueOf(carry).concat(result);
        }
        return result;
    }

}
