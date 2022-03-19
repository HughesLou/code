package com.hughes.lou.lintcode.easy;

import java.util.Stack;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class ReverseWordsInAString53 implements Easy {

    /**
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //按照空格将s切分
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        //从后往前遍历array，在sb中插入单词
        for (int i = array.length - 1; i >= 0; i--) {
            // 避免连续空格情况
            if (!array[i].equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(array[i]);
            }
        }
        return sb.toString();
    }

    public String reverseWords0(String s) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !temp.equals("")) {
                stack.push(temp);
                temp = "";
            } else if (s.charAt(i) != ' ') {
                temp += s.charAt(i);
            }
        }
        stack.push(temp);
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop() + " ";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }
}
