/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.hughes.lou.level.Easy;

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
        for (char aChar : chars) {
            if (values.containsKey(aChar)) {
                values.put(aChar, values.get(aChar) + 1);
            } else {
                values.put(aChar, 1);
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

    public int longestPalindrome1(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        int remove = set.size();
        // 回文串中字符个数为奇数的最多一个
        if (remove > 0) {
            remove -= 1;
        }
        return s.length() - remove;
    }
}
