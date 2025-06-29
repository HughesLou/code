package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses_241_Medium implements Medium {
    public List<Integer> diffWaysToCompute(String input) {
        int n = input.length();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ret.add(l + r);
                                break;
                            case '-':
                                ret.add(l - r);
                                break;
                            case '*':
                                ret.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ret.isEmpty()) ret.add(Integer.valueOf(input));
        return ret;
    }
}
