package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.Arrays;

public class MaximumLengthOfPairChain_646_Medium implements Medium {
    public int findLongestChain(int[][] pairs) {
        // 按区间终点升序排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
