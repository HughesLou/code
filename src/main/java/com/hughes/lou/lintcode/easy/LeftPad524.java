package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class LeftPad524 implements Easy {

    /**
     * @param originalStr: the string we want to append to with spaces
     * @param size: the target length of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            stringBuilder.append(padChar);
        }
        return stringBuilder.append(originalStr).toString();
    }
}
