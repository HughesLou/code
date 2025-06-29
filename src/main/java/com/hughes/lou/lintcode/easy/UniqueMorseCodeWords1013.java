package com.hughes.lou.lintcode.easy;

import java.util.HashSet;

import com.hughes.lou.level.Easy;

/**
 * 摩尔斯电码定义了一种标准编码，把每个字母映射到一系列点和短划线，例如：a -> .-，b -> -...，c ->-.-.。
 * <p>
 * 给出26个字母的完整编码表格：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
 * "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 现在给定一个单词列表，每个单词中每个字母可以写成摩尔斯编码。 例如，cba可以写成-.-.-....-，（把c,b,a的莫尔斯编码串接起来）。
 * 我们称之为一个词的转换。
 * <p>
 * 返回所有单词中不同变换的数量。
 *
 * @author HughesLou
 * Created on 2022-04-20
 */
public class UniqueMorseCodeWords1013 implements Easy {
    /**
     * @param words: the given list of words
     * @return: the number of different transformations among all words we have
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> s = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray()) {
                code.append(d[c - 'a']);
            }
            s.add(code.toString());
        }
        return s.size();
    }
}
