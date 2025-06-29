package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Naive;
import com.hughes.lou.utils.Utils;

/**
 * Created by Hughes on 2016/8/14.
 */
public class SortInteger464 implements Naive {

    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be
        // left <= right not left < right
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                Utils.swap(A, left, right);
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
