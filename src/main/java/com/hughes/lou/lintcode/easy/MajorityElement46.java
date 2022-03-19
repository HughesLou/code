package com.hughes.lou.lintcode.easy;

import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个整型数组，找出主元素，它在数组中的出现次数大于数组元素个数的二分之一。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class MajorityElement46 implements Easy {

    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        int currentMajor = 0;
        int count = 0;

        for (Integer num : nums) {
            if (count == 0) {
                currentMajor = num;
            }

            if (num == currentMajor) {
                count++;
            } else {
                count--;
            }
        }

        return currentMajor;
    }
}
