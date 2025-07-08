package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class CombinationSumIV_377_Medium implements Medium {
    public int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = new CombinationSumIV_377_Medium().combinationSum(nums, target);
        System.out.println(result);
    }
}
