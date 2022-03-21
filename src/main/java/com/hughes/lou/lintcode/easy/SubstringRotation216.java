package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定 s1 和 s2，请设计一种方法来检验 s2 是否为 s1 的循环移动后的字符串。
 * 你可以通过接口 Substring.isSubstring(s, t) 来检验某个单词t是否为另一个单词s的子字符串。
 * 注意，只能调用一次 Substring.isSubstring(s, t) 。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class SubstringRotation216 implements Easy {

    /**
     * @param s1 the first string
     * @param s2 the second string
     * @return true if s2 is a rotation of s1 or false
     */
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
            /* concatenate s1 and s1 within new buffer */
            String s1s1 = s1 + s1;
//            return Substring.isSubstring(s1s1, s2);
        }
        return false;
    }
}
