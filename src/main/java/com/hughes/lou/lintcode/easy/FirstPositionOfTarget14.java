package com.hughes.lou.lintcode.easy;

/**
 * @author HughesLou
 * Created on 2022-03-19
 */
public class FirstPositionOfTarget14 {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            // 得到中间位置
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }
}