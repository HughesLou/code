package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class SecondMaxOfArray479 implements Easy {

    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }

        return second;
    }
}