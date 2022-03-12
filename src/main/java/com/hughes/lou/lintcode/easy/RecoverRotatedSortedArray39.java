/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by hughes on 2017/12/16 22:22.
 */
public class RecoverRotatedSortedArray39 implements Easy {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(5);
        input.add(1);
        input.add(2);
        input.add(3);
        RecoverRotatedSortedArray39 recoverRotatedSortedArray = new RecoverRotatedSortedArray39();
        recoverRotatedSortedArray.recoverRotatedSortedArray(input);
        System.out.println(input);
    }

    /*
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null) {
            return;
        }
        int size = nums.size();
        for (int i = 0; i < size - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, size - 1);
                reverse(nums, 0, size - 1);
                return;
            }
        }
    }

    private void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int a = m - 1;
        int b = n - 1;
        for (int i = m + n - 1; i >= 0 && b >= 0; i--) {
            if (A[a] > B[b]) {
                A[i] = A[a--];
            } else {
                A[i] = B[b--];
            }
        }
    }
}
