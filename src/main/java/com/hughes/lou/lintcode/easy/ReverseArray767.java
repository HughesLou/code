package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.utils.Utils;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class ReverseArray767 implements Easy {
    /**
     * @param nums: a integer array
     * @return: nothing
     */
    public void reverseArray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            Utils.swap(nums, i, j);
            ++i;
            --j;
        }
    }
}
