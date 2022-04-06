package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-06
 */
public class ShortestWordDistance924 implements Easy {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        boolean compare = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                compare = true;
            }
            if (words[i].equals(word2)) {
                p2 = i;
                compare = true;
            }
            if (compare && p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
                compare = false;
            }
        }
        return min;
    }
}