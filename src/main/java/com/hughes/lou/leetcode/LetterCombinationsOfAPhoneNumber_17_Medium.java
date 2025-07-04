package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17_Medium implements Medium {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            combination("", digits, 0, ret);
        }
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset == digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(offset) - '0'];
        for (char c : letters.toCharArray()) {
            combination(prefix + c, digits, offset + 1, ret);
        }
    }
}
