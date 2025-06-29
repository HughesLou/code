package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-19
 */
public class MergeTwoSortedArrays6 implements Easy {

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }

        int[] result = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                result[index++] = A[i++];
            } else {
                result[index++] = B[j++];
            }
        }
        while (i < A.length) {
            result[index++] = A[i++];
        }
        while (j < B.length) {
            result[index++] = B[j++];
        }
        return result;
    }
}