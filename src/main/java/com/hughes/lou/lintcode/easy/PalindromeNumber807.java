package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class PalindromeNumber807 implements Easy {
    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        int[] bin = new int[32];
        int len = 0;
        while (n > 0) {
            bin[len++] = n & 1;
            n >>= 1;
        }
        for (int i = 0; i < len / 2; i++) {
            if (bin[i] != bin[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
