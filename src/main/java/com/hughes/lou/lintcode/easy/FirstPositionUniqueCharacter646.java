/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * Created by Hughes on 2018/1/20 19:41.
 */
public class FirstPositionUniqueCharacter646 implements Easy {

    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> values = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            values.put(s.charAt(i), values.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (values.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
