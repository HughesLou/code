package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.hughes.lou.level.Easy;

/**
 * 异位词数组排序
 * <p>
 * 编写一个方法来对字符串数组进行排序，以使所有字符串彼此相邻，
 * 并且按照重构之后的顺序来排序，且重构之后相同的字符串应该保持与相对位置不变
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class SortAnagramsArray292 implements Easy {

    public String[] SortAnagramsArray(String[] str) {
        TreeMap<String, ArrayList<String>> treeMap = new TreeMap<>();

        for (String item : str) {
            String key = sortString(item);
            if (treeMap.containsKey(key)) {
                treeMap.get(key).add(item);
            } else {
                treeMap.put(key, new ArrayList<>());
                treeMap.get(key).add(item);
            }
        }

        int index = 0;

        for (List<String> value : treeMap.values()) {
            for (String s : value) {
                str[index++] = s;
            }
        }
        return str;
    }

    /**
     * @param s: a string array
     * @return: return a sorted string array
     */
    public String sortString(String s) {
        int[] mapper = new int[26];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            mapper[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            while (mapper[i] > 0) {
                res.append((char) ('a' + i));
                mapper[i]--;
            }
        }
        return res.toString();
    }
}
