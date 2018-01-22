/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hughes on 2018/1/20 19:41.
 */
public class FirstPositionUniqueCharacter646 {

    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
        Map<Character, Integer> values = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (values.containsKey(s.charAt(i))) {
                values.put(s.charAt(i), values.get(s.charAt(i)) + 1);
            } else {
                values.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (values.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
