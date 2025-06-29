package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class PartitionEqualSubsetSum_416_Medium implements Medium {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        int n = nums.length;
        for (int i = 0; i <= W; i++) {
            dp[i] = nums[0] == i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = W; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[W];
    }
}
