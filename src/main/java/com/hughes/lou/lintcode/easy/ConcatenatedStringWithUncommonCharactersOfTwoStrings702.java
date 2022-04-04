package com.hughes.lou.lintcode.easy;

import java.util.HashSet;
import java.util.Set;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给出两个字符串, 你需要修改第一个字符串，将所有与第二个字符串中相同的字符删除,
 * 并且第二个字符串中不同的字符与第一个字符串的不同字符连接
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class ConcatenatedStringWithUncommonCharactersOfTwoStrings702 implements Easy {
    /**
     * 先用set 统计 s2 中出现的字母，然后遍历s1，把s1中未出现于set中的字母用stringbuilder拼接，
     * 同时要把s1 s2公共字母存在set2中
     * 最后遍历一遍s2，把s2中不是公共部分的字母拼接上去 最终得到结果
     *
     * @param s1: the 1st string
     * @param s2: the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (Character c : s2.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        Set<Character> commonSet = new HashSet<>();
        for (Character c : s1.toCharArray()) {
            if (set.contains(c)) {
                commonSet.add(c);
            } else {
                // 自动去重
                result.append(c);
            }
        }

        for (Character c : s2.toCharArray()) {
            if (!commonSet.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}