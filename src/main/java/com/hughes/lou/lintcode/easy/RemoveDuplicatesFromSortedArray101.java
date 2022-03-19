package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给你一个排序数组，删除其中的重复元素，使得每个数字最多出现两次，返回新的数组的长度。
 * 如果一个数字出现超过2次，则这个数字最后保留两个。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class RemoveDuplicatesFromSortedArray101 implements Easy {

    /*
     * @param nums: An integer array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                if (count < 2) {
                    nums[++index] = nums[i];
                    count++;
                }
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }
}
