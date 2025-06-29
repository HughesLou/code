package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-19
 */
public class LongestWord133 implements Easy {

    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        List<String> wordList = new ArrayList<>();
        int maxLength = 0;
        for (String word : dictionary) {
            int length = word.length();
            if (length >= maxLength) {
                if (length > maxLength) {
                    wordList.clear();
                }
                wordList.add(word);
                maxLength = length;
            }
        }
        return wordList;
    }
}
