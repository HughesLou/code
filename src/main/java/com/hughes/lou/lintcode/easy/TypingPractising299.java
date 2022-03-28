package com.hughes.lou.lintcode.easy;

import java.util.Stack;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 小千在教弟弟小泉打字，可是弟弟老是打错，当弟弟打错时，
 * 小千总是会按下'<'符号，表示删除错误的一个字符。（'<'代表回退backspace）
 * 小泉现在是初级水平，所以他打的字符均是小写字母。
 * 请问删除错误的字符后，正确的结果是什么呢？
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class TypingPractising299 implements Easy {

    /**
     * @param s: A string
     * @return: A string
     */
    public String getTextcontent(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '<') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
