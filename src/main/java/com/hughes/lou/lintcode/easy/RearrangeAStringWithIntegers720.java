/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by Hughes on 2018/1/20 23:49.
 */
public class RearrangeAStringWithIntegers720 implements Easy {

    /*
     * @param str: a string containing uppercase alphabets and integer digits
     * @return: the alphabets in the order followed by the sum of digits
     */
    public String rearrange(String str) {
        // Write your code here
        if (null == str) {
            return null;
        }
        int[] array = new int[256];
        int sum = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ++array[str.charAt(i)];
            } else {
                sum += ch - '0';
            }
        }

        for (int i = (int) 'A'; i < (int) 'Z'; ++i) {
            while (array[i]-- > 0) {
                result.append((char) i);
            }
        }
        if (sum > 0) {
            result.append(sum);
        }
        return result.toString();
    }
}
