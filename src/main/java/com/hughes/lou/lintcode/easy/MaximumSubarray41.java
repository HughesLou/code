package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * 每个子数组的数字在数组中的位置应该是连续的。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class MaximumSubarray41 implements Easy {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // maxAns记录全局最大值 sum记录当前子数组的和
        int maxAns = Integer.MIN_VALUE, sum = 0;
        // 贪心
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxAns = Math.max(maxAns, sum);
            sum = Math.max(sum, 0);
        }

        return maxAns;
    }
}
