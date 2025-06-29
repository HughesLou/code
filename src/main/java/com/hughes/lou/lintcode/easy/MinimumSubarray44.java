package com.hughes.lou.lintcode.easy;

import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给定一个整数数组，找到一个具有最小和的连续子数组。返回其最小和。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class MinimumSubarray44 implements Easy {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // maxAns记录全局最小值 sum记录当前子数组的和
        int minAns = Integer.MAX_VALUE, sum = 0;
        // 贪心
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            minAns = Math.min(minAns, sum);
            sum = Math.min(sum, 0);
        }

        return minAns;
    }
}
