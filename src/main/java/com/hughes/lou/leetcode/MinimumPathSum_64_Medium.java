package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class MinimumPathSum_64_Medium implements Medium {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一列
                if (j == 0) dp[0] += grid[i][0];
                // 第一行
                else if (i == 0) dp[j] = dp[j - 1] + grid[0][j];
                else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
