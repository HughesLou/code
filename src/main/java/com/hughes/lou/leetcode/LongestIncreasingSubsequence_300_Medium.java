package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class LongestIncreasingSubsequence_300_Medium implements Medium {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
