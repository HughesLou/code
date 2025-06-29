package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class MergeSortedArray64 implements Easy {

    /*
     * A有足够的空间，所以需要从后面开始
     *
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int position = m + n - 1;
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[position--] = A[i--];
            } else {
                A[position--] = B[j--];
            }
        }

        while (i >= 0) {
            A[position--] = A[i--];
        }

        while (j >= 0) {
            A[position--] = B[j--];
        }
    }
}
