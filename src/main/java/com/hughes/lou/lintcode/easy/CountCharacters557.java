package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class CountCharacters557 implements Easy {
    /*
     * @param str: a string
     * @return: Return a hash map
     */
    public Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        if (str != null) {
            for (Character c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }
}
