package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定两个字符串 s 和 t ，确定它们是否是同构的。
 * 两个字符串是同构的如果 s 中的字符可以被替换得到 t。
 * 所有出现的字符必须用另一个字符代替，同时保留字符串的顺序。
 * 没有两个字符可以映射到同一个字符，但一个字符可以映射到自己。
 *
 * @author HughesLou
 * Created on 2022-04-02
 */
public class IsomorphicStrings638 implements Easy {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        int[] S = new int[256];
        int[] T = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (S[s.charAt(i)] != T[t.charAt(i)]) {
                return false;
            }
            S[s.charAt(i)] = i + 1;
            T[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        // Write your code here
        int[] map = new int[256];  // ASCII 的范围是0-255
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (map[sc[i]] == 0) {
                map[sc[i]] = tc[i];
            } else {
                if (map[sc[i]] != tc[i]) {
                    return false;
                }
            }
        }

        int[] map2 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (map2[tc[i]] == 0) {
                map2[tc[i]] = sc[i];
            } else {
                if (map2[tc[i]] != sc[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}