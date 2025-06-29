package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-29
 */
public class LargestLetter353 implements Easy {

    /**
     * @param s: a string
     * @return: a string
     */
    public String largestLetter(String s) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(key(c), true);
        }

        for (int i = 25; i >= 0 ; i--) {
            if (map.containsKey(i) && map.containsKey(i + 30)) {
                return Character.toString((char) (i + 'A'));
            }
        }
        return "NO";
    }

    private int key(char c) {
        // 30只是用来区分两组字母，任意不小于26的数都可以
        return c >= 'a' && c <= 'z' ? c - 'a' : 30 + c - 'A';
    }
}
