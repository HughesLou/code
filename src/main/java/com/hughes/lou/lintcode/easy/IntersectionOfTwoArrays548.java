package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 每个元素出现次数得和在数组里一样
 * 答案可以以任意顺序给出
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class IntersectionOfTwoArrays548 implements Easy {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     * we will sort your return value in output
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }

        for (int num2 : nums2) {
            int count = map.getOrDefault(num2, 0);
            if (count > 0) {
                result.add(num2);
                if (--count > 0) {
                    map.put(num2, count);
                } else {
                    map.remove(num2);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}