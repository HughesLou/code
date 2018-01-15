/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luzhiwei01 on 2017/12/24 21:59.
 */
public class SubarraySum138 {

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum = nums[i];
            if (0 == sum) {
                result.add(i);
                result.add(i);
                break;
            } else {
                for (int j = i + 1; j < nums.length; ++j) {
                    sum += nums[j];
                    if (0 == sum) {
                        result.add(i);
                        result.add(j);
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
