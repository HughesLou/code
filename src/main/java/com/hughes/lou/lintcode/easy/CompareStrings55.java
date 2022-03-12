/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by hughes on 2017/12/16 23:27.
 */
public class CompareStrings55 implements Easy {
    /*
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
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
}
