package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.Arrays;

public class TargetSum_494_Medium implements Medium {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        return subsetSum(nums, (sum + S) >>> 1);
    }

    private int subsetSum(int[] nums, int target) {
//        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
