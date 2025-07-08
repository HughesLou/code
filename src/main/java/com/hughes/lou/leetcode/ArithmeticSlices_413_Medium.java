package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class ArithmeticSlices_413_Medium implements Medium {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int dp = 0, sum = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp++;
                sum += dp;
            } else {
                dp = 0;
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ret = 0;
        for (int cnt : dp) {
            ret += cnt;
        }
        return ret;
    }
}
