package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-06
 */
public class CapitalizesTheFirstLetter936 implements Easy {
    /**
     * @param s: a string
     * @return: a string after capitalizes the first letter
     */
    public String capitalizesFirst(String s) {
        int n = s.length();
        char[] sChar = s.toCharArray();
        if (sChar[0] >= 'a' && sChar[0] <= 'z') {
            sChar[0] -= 32;
        }
        for (int i = 1; i < n; i++) {
            if (sChar[i - 1] == ' ' && sChar[i] != ' ') {
                sChar[i] -= 32;
            }
        }
        return String.valueOf(sChar);
    }
}
