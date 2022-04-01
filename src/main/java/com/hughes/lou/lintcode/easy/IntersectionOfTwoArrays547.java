package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class IntersectionOfTwoArrays547 implements Easy {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     * we will sort your return value in output
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }

        for (int num2 : nums2) {
            if (set.contains(num2)) {
                result.add(num2);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}