package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给出文本 text ，其中有 n 条句子，每个句子由数个单词组成（数量大于 0），
 * 以及一个宽度 width，请将句子进行美观打印在宽度为 width 的窗口内。
 * 打印的规则如下：
 * <p>
 * 两条句子不应该在同一行，即打印完一个句子后应该换行。
 * 每个句子中，单词应该从左往右顶格打印，两个单词之间用一个空格隔开。
 * 如果一行中右侧剩下的空格不足填入新的单词，那么换行，从头开始打印。
 * 每一行末尾要用空格填充，使其长度和 width 相等。
 * 打印结果要用一圈星号 '*' 包装，星号不计入宽度中。
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class PrettyPrint352 implements Easy {

    /**
     * @param text: the text to print
     * @param width: the width of the window
     * @return: return the result of pretty print.
     */
    public List<String> prettyPrint(List<List<String>> text, int width) {
        List<String> result = new ArrayList<>();
        result.add(addEmptyLine(width));
        for (List<String> line : text) {
            result.addAll(addWordsToLines(line, width));
        }
        result.add(addEmptyLine(width));
        return result;
    }

    private String addEmptyLine(int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width + 2; ++i) {
            sb.append("*");
        }
        return sb.toString();
    }

    private List<String> addWordsToLines(List<String> words, int width) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (sb.length() + word.length() > width) {
                result.add(buildLine(sb, width));
                sb.setLength(0);
            }
            sb.append(sb.length() == 0 ? "*" : " ").append(word);
        }
        result.add(buildLine(sb, width));
        return result;
    }

    private String buildLine(StringBuilder sb, int width) {
        for (int i = sb.length(); i <= width; i++) {
            sb.append(" ");
        }
        sb.append("*");
        return sb.toString();
    }
}
