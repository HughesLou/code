package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给你一个只含有可见字符（ASCII 码范围 32 至 126）文本文件，文件中可能出现一些重复的单词，你需要对它们进行压缩。
 * 压缩规则如下：
 * <p>
 * 如果原文件中的字符不是英文字符，那么保留这些字符。
 * 我们将连续的英文字符视为一个单词，单词的前后不应该还有其它的英文字符。
 * 如果一个单词在它之前的文本中没有出现过，那么保留它。
 * 如果一个单词在它之前出现过，将其替换成前文中它第一次出现是第几个不同单词的编号。
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class TextCompression336 implements Easy {
    /**
     * @param lines: the text to compress.
     * @return: return the text after compression.
     */
    public String[] textCompression(String[] lines) {
        String[] result = new String[lines.length];
        // 记录单词出现的位置
        Map<String, Integer> positionMap = new HashMap<>();
        int position = 1;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (!Character.isLetter(ch)) {
                    stringBuilder.append(ch);
                } else {
                    int k = j;
                    while (k < line.length() && Character.isLetter(line.charAt(k))) {
                        k++;
                    }
                    String word = line.substring(j, k);
                    if (positionMap.containsKey(word)) {
                        stringBuilder.append(positionMap.get(word));
                    } else {
                        positionMap.put(word, position++);
                        stringBuilder.append(word);
                    }

                    j = k - 1;
                }
            }
            result[i] = stringBuilder.toString();
        }
        return result;
    }
}
