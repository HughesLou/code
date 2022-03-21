package com.hughes.lou.lintcode.easy;

/**
 * 给出一个字符串，找出第一个只出现一次的字符。假设只出现一次的字符数量大于等于1。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class FirstUniqueCharacterInAString209 {

    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int[] record = new int[256];
        for (int i = 0; i < str.length(); i++) {
            record[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (record[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '0';
    }

    public char firstUniqChar0(String s) {
        for (int i = 0; i < s.length(); i++) {
            int first = s.indexOf(s.charAt(i));
            int last = s.lastIndexOf(s.charAt(i));
            if (first == last) {
                return s.charAt(i);
            }
        }
        return '0';
    }
}
