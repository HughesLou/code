package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回 -1。
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class ClassicalBinarySearch457 implements Easy {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}