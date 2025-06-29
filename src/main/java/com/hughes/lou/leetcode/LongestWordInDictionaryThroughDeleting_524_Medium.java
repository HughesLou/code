package com.hughes.lou.leetcode;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting_524_Medium {
    public String findLongestWord(String s, List<String> words) {
        String res = "";
        for (String word : words) {
            int j = 0;
            for (int i = 0; i < s.length() && j < word.length(); i++) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
            }
            if (j == word.length()) {
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }
}
