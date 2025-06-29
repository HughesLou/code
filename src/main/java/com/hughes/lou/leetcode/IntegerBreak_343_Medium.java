package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class IntegerBreak_343_Medium implements Medium {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}
