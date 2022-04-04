package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个整数数组，求出无序整数的最短子序列的长度。如果一组整数既不递减也不递增，则称为无序。
 * [提示：开始检查它是否递增/递减并返回0，否则检查是否存在无序的三元组。如果是，则返回3，否则返回0]
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class ShortestUnorderedArray757 implements Easy {
    /**
     * @param arr: an array of integers
     * @return: the length of the shortest possible subsequence of integers that are unordered
     */
    public int shortestUnorderedArray(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        // 通过符号位来判定(位移比乘法更快)
        for (int i = 2; i < arr.length; i++) {
            if ((((arr[i] - arr[i - 1]) >> 31) != ((arr[i - 1] - arr[i - 2]) >> 31))) {
                return 3;
            }
        }
        return 0;
    }
}