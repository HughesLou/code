package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class BestTimeToBuyAndSellStockWithCooldown_309_Medium implements Medium {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // buy, 前一天对应buy或cooldown，max(cooldown, buy)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // sell, 前一天对应buy/cooldown状态
            dp[i][1] = dp[i - 1][0] + prices[i];
            // cooldown, max(sell, cooldown)
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 当前持仓是买入
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            // 当前持仓是卖出
            sell[i] = buy[i - 1] + prices[i];
            // 当前持仓是空仓
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }
}
