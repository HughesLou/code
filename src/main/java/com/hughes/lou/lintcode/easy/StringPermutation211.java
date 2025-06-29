package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
 * <p>
 * 置换的意思是，通过改变顺序可以使得两个字符串相等。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class StringPermutation211 implements Easy {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        int[] cnt = new int[1000];
        for (int i = 0; i < A.length(); ++i) {
            cnt[A.charAt(i)] += 1;
        }
        for (int i = 0; i < B.length(); ++i) {
            cnt[B.charAt(i)] -= 1;
        }
        for (int i = 0; i < 1000; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
