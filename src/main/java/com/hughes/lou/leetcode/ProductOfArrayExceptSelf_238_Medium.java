package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class ProductOfArrayExceptSelf_238_Medium implements Medium {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;

        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
