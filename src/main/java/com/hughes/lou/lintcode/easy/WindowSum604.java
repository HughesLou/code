package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给你一个大小为n的整型数组和一个大小为k的滑动窗口，将滑动窗口从头移到尾，
 * 输出从开始到结束每一个时刻滑动窗口内的数的和。
 *
 * @author HughesLou
 * Created on 2022-04-01
 */
public class WindowSum604 implements Easy {

    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        // 结果个数为 length-k+1
        k--;
        int[] result = new int[length - k];
        for (int i = k; i < length; i++) {
            result[i - k] = sum[i] - sum[i - k] + nums[i - k];
        }
        return result;
    }
}