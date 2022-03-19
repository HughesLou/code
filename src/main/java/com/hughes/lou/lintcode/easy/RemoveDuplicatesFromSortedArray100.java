package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个排序数组，在原数组中“删除”重复出现的数字，使得每个元素只出现一次，并且返回“新”数组的长度。
 * <p>
 * 不要使用额外的数组空间，必须在不使用额外空间的条件下原地完成。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class RemoveDuplicatesFromSortedArray100 implements Easy {

    /*
     * @param nums: An integer array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
            }
        }
        return size + 1;
    }
}
