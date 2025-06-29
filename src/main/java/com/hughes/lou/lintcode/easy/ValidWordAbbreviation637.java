package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class ValidWordAbbreviation637 implements Easy {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        char[] s = word.toCharArray();
        char[] t = abbr.toCharArray();

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(t[j])) {
                if (t[j] == '0') {
                    return false;
                }
                int val = 0;
                while (j < abbr.length() && Character.isDigit(t[j])) {
                    val = val * 10 + t[j] - '0';
                    j++;
                }
                i += val;
            } else {
                if (s[i++] != t[j++]) {
                    return false;
                }
            }
        }
        return i == word.length() && j == abbr.length();
    }
}