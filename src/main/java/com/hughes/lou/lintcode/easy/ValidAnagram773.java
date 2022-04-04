package com.hughes.lou.lintcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class ValidAnagram773 implements Easy {
    /**
     * @param s: string s
     * @param t: string t
     * @return: Given two strings s and t, write a function to determine if t is an anagram of s.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram1(@Nonnull String s, @Nonnull String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> m1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        for (Character key : m1.keySet()) {
            if (m1.get(key) != m2.get(key)) {
                return false;
            }
        }
        return true;
    }
}
