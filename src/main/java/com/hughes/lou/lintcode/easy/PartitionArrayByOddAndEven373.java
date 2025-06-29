package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.utils.Utils;

/**
 * @author HughesLou
 * Created on 2022-03-29
 */
public class PartitionArrayByOddAndEven373 implements Easy {

    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 != 0 && left < right) {
                left++;
            }
            while (nums[right] % 2 == 0 && left < right) {
                right--;
            }
            if (left < right) {
                Utils.swap(nums, left, right);
            }
        }
    }
}
