package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares_279_Medium implements Medium {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>(); // 存储小于 n 的平方数
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = Integer.MAX_VALUE;
            for (int s : squares) {
                if (s > i) break;
                max = Math.min(max, dp[i - s] + 1);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
