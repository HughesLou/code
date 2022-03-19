package com.hughes.lou.lintcode.navie;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 在给定的数组中，找到出现次数最多的数字。出现次数相同时，返回数值最小的数字。
 *
 * @author HughesLou
 * Created on 2021-02-26
 */
public class MostNumbers1910 implements Easy {

    /**
     * @param array: An array.
     * @return: An integer.
     */
    public int findNumber(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int result = array[0];
        for (int value : array) {
            int count = map.getOrDefault(value, 0) + 1;
            map.put(value, count);

            if (count > max) {
                max = count;
                result = value;
            } else if (count == max && value < result) {
                result = value;
            }
        }
        return result;
    }
}