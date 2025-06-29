package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;

import com.hughes.lou.level.Easy;

/**
 * 给出一个字符串 str,你需要按顺序提取出该字符串的符号和单词。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class DataSegmentation956 implements Easy {

    /**
     * @param str: The input string
     * @return: The answer
     */
    public String[] dataSegmentation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (tmp.length() != 0) {
                    ans.add(tmp.toString());
                }
                tmp = new StringBuilder("");
            } else if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                if (tmp.length() != 0) {
                    ans.add(tmp.toString());
                }
                tmp = new StringBuilder();
                tmp.append(str.charAt(i));
                ans.add(tmp.toString());
                tmp = new StringBuilder();
            } else {
                tmp.append(str.charAt(i));
            }
        }
        if (tmp.length() != 0) {
            ans.add(tmp.toString());
        }
        return ans.toArray(new String[ans.size()]);
    }
}
