package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class HouseRobberII_213_Medium implements Medium {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int preMax = nums[left];
        int curMax = Math.max(preMax, nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int tmp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = tmp;
        }
        return curMax;
    }
}
