package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class MissingString684 implements Easy {
    /**
     * @param str1: a given string
     * @param str2: another given string
     * @return: An array of missing string
     */
    public List<String> missingString(String str1, String str2) {
        List<String> res = new ArrayList<>();

        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        Set<String> set = new HashSet<>();

        for (String str : arr2) {
            set.add(str);
        }

        for (String str : arr1) {
            if (!set.contains(str)) {
                res.add(str);
            }
        }

        return res;
    }
}