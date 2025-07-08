package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class TwoKeysKeyboard_650_Medium implements Medium {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // 初始值：通过复制1次+粘贴(i-1)次得到
            for (int j = (int)Math.sqrt(i); j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j; // 表示需要粘贴 (n/j - 1) 次（加上1次复制操作）
                    break; // 找到最大因数即可停止
                }
            }
        }
        return dp[n];
    }

    public int minSteps2(int n) {
        if (n == 1) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return i + minSteps2(n / i);
        }
        return n;
    }

}
