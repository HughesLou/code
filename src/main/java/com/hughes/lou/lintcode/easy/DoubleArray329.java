package com.hughes.lou.lintcode.easy;

import java.util.Arrays;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 数组加倍
 * <p>
 * 给定一个正整数数组arr，和一个正整数num
 * 遍历该正整数数组arr，如果当前的num和当前遍历的元素相同，则num变为本身的2倍
 * 现在请你对arr数组重排，使得最终的num最大
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class DoubleArray329 implements Easy {
    public int maxNum(int[] arr, int num) {
        Arrays.sort(arr);
        for (int a : arr) {
            if (a == num) {
                num *= 2;
            }
        }
        return num;
    }
}
