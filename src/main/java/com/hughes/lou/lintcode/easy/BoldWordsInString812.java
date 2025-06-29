package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给定一组关键字“words”和一个字符串“S”，将所有关键字以S粗体显示。
 * <b> 和 </b>标记之间的任何字母都将加粗。
 * 返回的字符串应该使用尽可能少的标签，当然这些标签应该组成一个有效的组合。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class BoldWordsInString812 implements Easy {
    /**
     * @param words: the words
     * @param S: the string
     * @return: the string with least number of tags
     */
    public String boldWords(String[] words, String S) {
        int[] s = new int[S.length() + 1];
        for (String w : words) {
            int i = 0;
            while ((i = S.indexOf(w, i)) >= 0) {
                s[i]++;
                s[i + w.length()]--;
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int pre = 0, sum = 0;
        for (int i = 0; i <= S.length(); i++) {
            sum += s[i];
            if (sum > 0 && pre == 0) {
                sb.append("<b>");
            }
            if (sum == 0 && pre > 0) {
                sb.append("</b>");
            }
            if (i < S.length()) {
                sb.append(S.charAt(i));
            }
            pre = sum;
        }
        return sb.toString();
    }
}
