package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.Arrays;

public class CoinChange_322_Medium implements Medium {
    private int minCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins); // 可选：先排序，为后续剪枝更高效
        dfs(coins, amount, 0, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    /**
     * @param coins  硬币数组
     * @param remain 当前剩余金额
     * @param index  当前从第 index 个硬币开始尝试
     * @param count  当前已经用的硬币数量
     */
    private void dfs(int[] coins, int remain, int index, int count) {
        // 剪枝：无效情况
        if (remain < 0) return;
        // 找到解
        if (remain == 0) {
            minCount = Math.min(minCount, count);
            return;
        }

        // 剪枝：如果已经比当前最小解多了，就不用继续了
        if (count >= minCount) return;

        for (int i = index; i < coins.length; i++) {
            dfs(coins, remain - coins[i], i, count + 1); // 可以重复使用当前硬币，所以 i 不变
        }
    }
}
