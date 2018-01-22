/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

/**
 * Created by Hughes on 2018/1/20 15:50.
 */
public class LengthOfLastWord422 {
    /*
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        if (null == s) {
            return 0;
        }
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (null != words[i] && !"".equals(words[i])) {
                return words[i].length();
            }
        }
        return 0;
    }
}
