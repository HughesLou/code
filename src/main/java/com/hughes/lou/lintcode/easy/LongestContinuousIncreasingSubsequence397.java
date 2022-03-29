package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
 * （最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class LongestContinuousIncreasingSubsequence397 implements Easy {

    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 1;
        int inCount = 1;
        int deCount = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                inCount++;
            } else {
                inCount = 1;
            }

            if (A[i] < A[i - 1]) {
                deCount++;
            } else {
                deCount = 1;
            }

            max = Math.max(max, Math.max(inCount, deCount));
        }

        return max;
    }
}
