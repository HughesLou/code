package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hughes.lou.level.Easy;

/**
 * 给出一个字符串，以 字符在串中出现的次数 为第一关键字，字典序为第二关键字排序字符串。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class StringSort830 implements Easy {

    public String stringSort(String str) {
        char[] S = str.toCharArray();
        int[] map = new int[26];
        for (char c : S) {
            if (map[c - 'a'] == 0) {
                map[c - 'a'] += 'z' - c;
            }
            map[c - 'a'] += 100;
        }
        Arrays.sort(map);
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (map[i] != 0) {
                int count = map[i] / 100;
                char c = (char) ('z' - (map[i] % 100));
                char[] A = new char[count];
                Arrays.fill(A, c);
                sb.append(A);
            }
        }
        return sb.toString();
    }

    public String stringSort1(String str) {
        if (str == null) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<Entry<Character, Integer>> list = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        });

        return sb.toString();
    }
}
