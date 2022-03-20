package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 实现一个算法确定字符串中的字符是否均唯一出现
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class UniqueCharacters157 implements Easy {

    /**
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

}
