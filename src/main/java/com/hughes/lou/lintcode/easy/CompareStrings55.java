/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 * <p>
 * Created by hughes on 2017/12/16 23:27.
 */
public class CompareStrings55 implements Easy {
    /*
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A.length() < B.length()) {
            return false;
        }
        for (char b : B.toCharArray()) {
            int index = A.indexOf(b);
            if (index > -1) {
                A = A.replaceFirst(Character.toString(b), "");
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean compareStrings0(String A, String B) {
        //counts首先记录A中所有的字符以及它们的个数，然后遍历B,如果出现counts[i]小于0的情况，说明B中该字符出现的次数
        //大于在A中出现的次数
        int[] counts = new int[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < A.length(); i++) {
            counts[A.charAt(i) - 'A']++;
        }
        for (int i = 0; i < B.length(); i++) {
            counts[B.charAt(i) - 'A']--;
            if (counts[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }
}
