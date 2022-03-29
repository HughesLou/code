package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 滑动数独
 * <p>
 * 给定一个3×n 的矩阵 number，并且该矩阵只含有1到9的正整数。
 * 考虑有一个大小为3×3 滑动窗口，从左到右遍历该矩阵 number，
 * 那么该滑动窗口在遍历整个矩阵的过程中会有n-2个。
 * <p>
 * 现在你的任务是找出这些滑动窗口是否含有1到9的所有正整数
 * 请返回一个长度为n-2的答案数组，如果第i个滑动窗口含有1到9的所有正整数，那么答案数组的第i个元素为true，否则为false
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class SlideSoduku326 implements Easy {

    /**
     * 最简单的滑动窗口，窗口大小为3，
     * 每次移动窗口时加入当前i列的元素，删去i-3列（如果存在）的元素,统计一下是否包含1-9所有数即可
     *
     * @param number: an only contains from 1 to 9 array
     * @return: return  whether or not each sliding window position contains all the numbers for 1 to 9
     */
    public boolean[] SlidingWindows(int[][] number) {
        int n = number[0].length;
        boolean[] result = new boolean[n - 2];
        int[] vis = new int[10];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                count = vis[number[j][i]]++ == 0 ? count + 1 : count;
            }
            if (i > 2) {
                for (int j = 0; j < 3; j++) {
                    count = --vis[number[j][i - 3]] == 0 ? count - 1 : count;
                }
            }
            if (i >= 2) {
                result[i - 2] = count == 9;
            }
        }
        return result;
    }
}
