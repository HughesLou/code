package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 * <p>
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class UniquePaths115 implements Easy {

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // 若遇到障碍物，以为不可到达，则跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                // 对于上边界，第一个障碍物或边界左边的所有边界点皆可到达
                if (i == 0) {
                    dp[0][j] = dp[0][j - 1];
                    continue;
                }
                // 对于左边界，第一个障碍物或边界前的所有边界点皆可到达
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0];
                    continue;
                }
                // 到达当前点的路径数等于能到达此点上面的点和左边点的路径数之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public int uniquePaths(int m, int n) {
        // corner case
        if (m == 1 || n == 1) {
            return 1;
        }

        // 保证m<=n
        if (m > n) {
            // swap(m, n)
            int x = n;
            n = m;
            m = x;
        }

        // 计算阶乘
        double temp = 1;
        double result = 1;
        for (int i = 1; i < m; i++) {
            temp *= i;
        }
        for (int i = n; i < m + n - 1; i++) {
            result *= i;
        }
        return (int) Math.round(result / temp);
    }

    public int uniquePaths0(int m, int n) {
        int[][] result = new int[m][n];
        result[0][0] = 1;
        for (int i = 1; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }

        return result[m - 1][n - 1];
    }
}
