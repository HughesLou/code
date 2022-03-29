package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-29
 */
public class ValidNumber417 implements Easy {
    /**
     * 首先应该明确合法的数字有哪些:
     * <p>
     * 整数, 例如 "122", "114"
     * 浮点数, 例如 "1.2", "2.", ".5", "1e10", "1E10"
     * 上面两种数加上符号, 即 "+" 或 "-"
     *
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        int i = 0;
        // 多增加一个空格，避免后面每一步都要判断是否越界
        s = s.trim() + " ";
        char[] sc = s.toCharArray();
        int len = s.length() - 1;

        if (sc[i] == '+' || sc[i] == '-') {
            i++;
        }
        int nDigit = 0, nPoint = 0;
        while (Character.isDigit(sc[i]) || sc[i] == '.') {
            if (sc[i] == '.') {
                nPoint++;
                if (nPoint > 1) {
                    return false;
                }
            } else {
                nDigit++;
            }
            i++;
        }
        if (nDigit <= 0) {
            return false;
        }

        if (sc[i] == 'e' || sc[i] == 'E') {
            i++;
            if (sc[i] == '+' || sc[i] == '-') {
                i++;
            }
            if (i == len) {
                return false;
            }
            for (; i < len; i++) {
                if (!Character.isDigit(sc[i])) {
                    return false;
                }
            }
        }
        return i == len;
    }
}
