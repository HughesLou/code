package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
 * 必须保证不存在超过2个相邻的柱子颜色相同，求有多少种染色方案。
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class PaintFence514 implements Easy {

    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        int[] result = {0, k, k * k, 0};
        if (n <= 2) {
            return result[n];
        }
        if (k == 1) {
            return 0;
        }

        int a = k -1;
        for (int i = 2; i < n; i++) {
            result[3] = a * (result[2] + result[1]);
            result[1] = result[2];
            result[2] = result[3];
        }
        return result[3];
    }
}
