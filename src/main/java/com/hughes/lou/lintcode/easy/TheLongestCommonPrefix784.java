package com.hughes.lou.lintcode.easy;

import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给出n个字符串dic,和一个目标串，输出目标串与这n个字符串的最长公共前缀的长度的最大值。
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class TheLongestCommonPrefix784 implements Easy {
    /**
     * @param dic: the n strings
     * @param target: the target string
     * @return: The ans
     */
    public int theLongestCommonPrefix(List<String> dic, String target) {
        int ans = 0;
        for (String it : dic) {
            int same = 0;
            for (int i = 0; i < target.length(); i++) {
                if (i > it.length() - 1 || target.charAt(i) != it.charAt(i)) {
                    break;
                }
                same++;
            }
            ans = Math.max(ans, same);
        }
        return ans;
    }
}
