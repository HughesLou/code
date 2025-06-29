package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 小括号匹配
 * <p>
 * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')'， 判定是否是有效的括号序列。
 * 括号必须依照 "()" 顺序表示， "()" 是有效的括号，但 ")(" 则是无效的括号。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class MatchingOfParentheses263 implements Easy {
    /**
     * @param string: A string
     * @return: whether the string is valid
     */
    public boolean matchParentheses(String string) {
        int matched = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                matched++;
            } else {
                matched--;
            }

            if (matched < 0) {
                return false;
            }
        }

        return matched == 0;
    }
}
