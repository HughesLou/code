package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 单词间距
 * <p>
 * 给出一系列单词 words，以及两个不同的单词 wordA 和 wordB，请找出最近的两个 wordA 和 wordB 的间距。
 * 如果 words 中不存在 wordA 或 wordB，那么返回 -1−1。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class WordSpacing277 implements Easy {
    /**
     * @param words: the words given.
     * @param wordA: the first word you need to find.
     * @param wordB: the second word you need to find.
     * @return: return the spacing of the closest wordA and wordB.
     */
    public int wordSpacing(List<String> words, String wordA, String wordB) {
        int curSpace, minSpace = -1;
        int indexA = -1, indexB = -1;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(wordA)) {
                indexA = i;
                if (indexB >= 0) {
                    curSpace = indexA - indexB;
                    if (minSpace <= 0 || curSpace < minSpace) {
                        minSpace = curSpace;
                    }
                }
            } else if (words.get(i).equals(wordB)) {
                indexB = i;
                if (indexA >= 0) {
                    curSpace = indexB - indexA;
                    if (minSpace <= 0 || curSpace < minSpace) {
                        minSpace = curSpace;
                    }
                }
            }
        }
        return minSpace;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String all = scanner.nextLine();
        String wordA = scanner.nextLine();
        String wordB = scanner.nextLine();
        List<String> words = new ArrayList<>();
        for (String word : all.split(" ")) {
            words.add(word);
        }

        System.out.println(new WordSpacing277().wordSpacing(words, wordA, wordB));
    }
}