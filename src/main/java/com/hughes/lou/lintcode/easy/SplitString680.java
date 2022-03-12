/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by Hughes on 2018/1/20 20:13.
 */
public class SplitString680 implements Easy {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        } else if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        dfsHelper(results, new ArrayList<>(), 0, s);

        return results;
    }

    private void dfsHelper(List<List<String>> results, List<String> result, int index, String s) {
        if (index == s.length()) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < index + 2 && i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            result.add(substring);
            dfsHelper(results, result, i + 1, s);
            result.remove(result.size() - 1);
        }
    }
}
