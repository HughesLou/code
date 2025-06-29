package com.hughes.lou.lintcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hughes.lou.level.Easy;

/**
 * 特殊回文字符串
 * <p>
 * 有一个双向配对的字母列表，比如：a<->t, b<->y, y<->h, h<->n, m<->w, w<->w …
 * 给定一个字符串，如果它是回文字符串，返回true。其中的字母可以被另一个对应的字母替换，但不允许嵌套替换，即a<-->b， b<-->c， 但a<-/->c。
 * <p>
 * 例如，字符串 “swims” 返回true，因为“w”可以被“m”替换，而字符串会变成“smims”，是回文字符串。
 * 字符串 “hob” 也返回true，因为“h”可以被“y”替换，“b”也可以被替换为“y”。然后字符串"yoy"也是回文。
 * 但是，字符串 “ban” 返回false，因为嵌套替换是不允许的。即使“b“可以变成“y“，“n“可以变成“h“，新的字符串“yah“也不是回文。
 *
 * @author HughesLou
 * Created on 2022-03-26
 */
public class SpecialPalindromeString250 implements Easy {


    /**
     * 列表ambigram中的每一位均为2个字母，代表其可以相互转换。
     * 列表ambigram的长度不超过10,000
     * 字符串word的长度不超过1,000
     * 数据保证均为小写字母。
     *
     * @param ambigram: A list of paired ambigram letter.
     * @param word: A string need to be judged.
     * @return: If it is special palindrome string, return true.
     */
    public boolean isPalindrome(List<String> ambigram, String word) {
        // 经测试word为空串时返回true
        int start = 0;
        int end = word.length() - 1;
        // 从两边遍历word，若前后可以匹配则继续，否则返回false，遍历结束返回true
        // 记录可替换的所有字符
        Set<Character> startSet;
        Set<Character> endSet;
        while (start < end) {
            char startChar = word.charAt(start);
            char endChar = word.charAt(end);
            if (!(startChar == endChar)) {
                // 前后字符不相同，匹配，否则移动位置进行下一轮判断
                startSet = getReplaceList(startChar, ambigram);
                endSet = getReplaceList(endChar, ambigram);
                if (!hasCommonItem(startSet, endSet)) {
                    return false;
                }
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

    private Set<Character> getReplaceList(Character c, List<String> ambigram) {
        // 在ambigram中查找c的所有可替换字符
        Set<Character> set = new HashSet<>();
        // 字符自身是可替换的
        set.add(c);
        for (String str : ambigram) {
            if (str.charAt(0) == c) {
                set.add(str.charAt(1));
            } else if (str.charAt(1) == c) {
                set.add(str.charAt(0));
            }
        }

        return set;
    }

    private boolean hasCommonItem(Set<Character> set1, Set<Character> set2) {
        // 查看两Set中是否有相同元素
        for (Character c1 : set1) {
            for (Character c2 : set2) {
                if (c1 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}