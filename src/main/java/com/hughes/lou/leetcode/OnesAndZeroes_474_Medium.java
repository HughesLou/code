package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class OnesAndZeroes_474_Medium implements Medium {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else if (c == '1') {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }

        }
        return dp[m][n];
    }
}
