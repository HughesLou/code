package com.hughes.lou.lintcode.easy;

import java.util.HashSet;
import java.util.Set;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class RemoveDuplicateNumbersInArray521 implements Easy {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (Integer i : set) {
            nums[result++] = i;
        }
        return result;
    }
}