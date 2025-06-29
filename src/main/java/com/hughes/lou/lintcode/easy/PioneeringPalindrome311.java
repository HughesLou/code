package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * 重构回文
 * <p>
 * 给定一个字符串，通过交换某些字符后，请问此字符串能否变成一个回文串。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class PioneeringPalindrome311 implements Easy {

    /**
     * 我们并不需要通过调换位置去判断能不能变成回文串
     * 一个回文串中，最多一个字符出现奇数次
     * 我们通过一个hashmap/dict来记录每一个字母都出现了几次
     * 然后我们统计一下出现次数为奇数的个数
     * 如果这个个数大于1，说明无法构成回文串
     *
     * @param s: A string containing only uppercase and lowercase letters
     * @return: Judge whether it can become a palindrome
     */
    public boolean isPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.remove(c);
            } else {
                map.put(c, 1);
            }
        }

        return map.size() < 2;
    }
}
