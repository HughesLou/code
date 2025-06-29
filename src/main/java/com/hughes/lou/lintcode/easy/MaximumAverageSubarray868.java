package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class MaximumAverageSubarray868 implements Easy {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        // 前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            ans = Math.max(ans, sum[i] - sum[i - k]);
        }
        return ans * 1.0 / k;
    }
}
