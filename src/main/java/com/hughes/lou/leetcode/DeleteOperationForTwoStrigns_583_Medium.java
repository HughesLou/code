package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class DeleteOperationForTwoStrigns_583_Medium implements Medium {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    // 先计算LCS
    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) continue;
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
