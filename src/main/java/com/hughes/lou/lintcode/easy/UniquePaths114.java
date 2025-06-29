package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 有一个机器人的位于一个 m×n 个网格左上角。
 * <p>
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * <p>
 * 问有多少条不同的路径？
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class UniquePaths114 implements Easy {

    /**
     * 不难发现，机器人从左上角走到右下角，需要向下走m - 1步，向右走n - 1步，那么总步数也是一定的，为m + n - 2步。
     * 问题就转化成，从m + n - 2步中选出m - 1步向下，其余步数自然是向右
     *
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
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
