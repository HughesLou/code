package com.hughes.lou.lintcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
 * 现在给出一个单词集合，需要统计这个集合中有多少种不同的循环单词。
 * <p>
 * 例如：picture 和 turepic 就是属于同一种循环单词。
 *
 * @author HughesLou
 * Created on 2022-04-02
 */
public class RotateWords671 implements Easy {

    /**
     * @param words: A set of words
     * @return: countRotateWords
     */
    public int countRotateWords(List<String> words) {
        Set<String> dict = new HashSet<>();

        for (String w : words) {
            String s = w + w;
            for (int i = 0; i < w.length(); i++) {
                dict.remove(s.substring(i, i + w.length()));
            }

            dict.add(w);
        }

        return dict.size();
    }
}
