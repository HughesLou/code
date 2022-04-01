package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class MoveZeros539 implements Easy {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] = 0;
            }
        }
    }
}
