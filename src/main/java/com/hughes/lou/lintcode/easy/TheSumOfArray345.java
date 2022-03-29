package com.hughes.lou.lintcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个数组A，找到数组A中所有小于当前位置A[i]的数字，并求出所有小于A[i]的数字之和，保存在B[i]的位置上
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class TheSumOfArray345 implements Easy {

    /**
     * 这里假设没有重复元素
     *
     * @param arr: An array
     * @return: An array
     */
    public int[] getSum(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        int[] array = Arrays.copyOf(arr, length);
        Arrays.sort(array);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = array[0];
        map.put(sum, 0);

        for (int i = 1; i < length; i++) {
            if (array[i] > array[i - 1]) {
                map.put(array[i], sum);
            }
            sum += array[i];
        }

        for (int i = 0; i < length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}
