package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 把字符串S中的字符从左到右写入行中。
 * 每行最大宽度度为100，如果往后新写一个字符导致该行宽度超过100，则写入下一行。
 * 注意：一个字符的宽度不为1！
 * <p>
 * 给定一个数组widths，其中widths[0]是字符a的宽度，widths[1]是字符b的宽度，...，widths[25]是字符'z'的宽度。
 * <p>
 * 问：把S全部写完，至少需要多少行？最后一行用去的宽度是多少？ 将结果作为长度为2的整数列表返回。
 *
 * @author HughesLou
 * Created on 2022-04-19
 */
public class NumberOfLinesToWriteString1011 implements Easy {
    /**
     * @param widths: an array
     * @param s: a string
     * @return: how many lines have at least one character from S, and what is the width used by the last such line
     */
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int lastWidth = 0;
        for (char c : s.toCharArray()) {
            lastWidth += widths[c - 'a'];
            if (lastWidth > 100) {
                lastWidth = widths[c - 'a'];
                line++;
            }
        }

        return new int[] {line, lastWidth};
    }
}