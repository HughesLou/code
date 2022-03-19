package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个只含非负整数的m∗n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class MinimumPathSum110 implements Easy {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // 若为空直接返回
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];

        // 初始化
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        //返回结果
        return f[m - 1][n - 1];
    }
}
