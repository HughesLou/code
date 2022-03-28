package com.hughes.lou.lintcode.easy;

import java.util.Arrays;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给出一个数组 nums，将数组中的数两两配对。
 * 令数组 sums 为配对后每组数字的和，要求 sums 的极差最小。
 * 请计算并返回可能的最小的sums的极差。
 * 极差就是数组中最大最小值的差值。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class DigitalPairing302 implements Easy {

    /**
     * @param nums: the integers to be paired.
     * @return: return the minimum difference of the maximum value and the minimum value after pairing.
     */
    public int digitalPairing(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length / 2; ++i) {
            nums[i] = nums[i] + nums[length - 1 - i];
        }
        int max = nums[0], min = nums[0];
        for (int i = 0; i < length / 2; ++i) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return max - min;
    }
}
