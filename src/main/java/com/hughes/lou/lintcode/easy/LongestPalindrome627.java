/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by Hughes on 2018/1/20 19:06.
 */
public class LongestPalindrome627 implements Easy {
    /*
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> values = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (values.containsKey(chars[i])) {
                values.put(chars[i], values.get(chars[i]) + 1);
            } else {
                values.put(chars[i], 1);
            }
        }
        int result = 0;
        boolean flag = false;

        for (Character character : values.keySet()) {
            int num = values.get(character);
            if (0 != num % 2) {
                result += num - 1;
                flag = true;
            } else {
                result += num;
            }
        }

        return flag ? result + 1 : result;
    }
}
