package com.hughes.lou.lintcode.easy;

import java.util.BitSet;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个字符串，判断字符串是否存在一个排列是回文排列
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class PalindromePermutation916 implements Easy {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        BitSet bs = new BitSet();
        for (byte b : s.getBytes()) {
            bs.flip(b);
        }
        return bs.cardinality() < 2;
    }

    public boolean canPermutePalindrome1(String s) {
        int odd = 0;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        return true;

    }
}
