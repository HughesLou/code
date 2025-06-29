package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * 给定一个模式串pattern和一个字符串str，请问str和pattern是否遵循相同的模式。
 * 这里遵循模式指的是一个完全匹配，即在pattern中的每个不同的字母和str中每个非空的单词之间有一个双向映射的模式对应。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class WordPattern828 implements Easy {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        Map<String, Integer> map1 = new HashMap<>();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            String key = String.valueOf(pattern.charAt(i));
            if (map1.containsKey(key)) {
                sb1.append(map1.get(key));
            } else {
                map1.put(key, i);
                sb1.append(i);
            }
        }

        Map<String, Integer> map2 = new HashMap<>();
        StringBuilder sb2 = new StringBuilder();
        String[] tests = teststr.split(" ");
        for (int i = 0; i < tests.length; i++) {
            if (map2.containsKey(tests[i])) {
                sb2.append(map2.get(tests[i]));
            } else {
                map2.put(tests[i], i);
                sb2.append(i);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}
