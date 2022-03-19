package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个未排序的整数数组，找到其中位数。中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class Median80 implements Easy {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        return sub(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }

    private int sub(int[] nums, int start, int end, int size) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        int i = start - 1, j = end + 1;
        for (int k = start; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            } else if (nums[k] > pivot) {
                j--;
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                k--;
            }
        }
        if (i - start + 1 >= size) {
            return sub(nums, start, i, size);
        } else if (j - start >= size) {
            return nums[j - 1];
        } else {
            return sub(nums, j, end, size - (j - start));
        }
    }

    // Please note: the `k` must be (nums.length + 1) / 2 - 1 in order to satisfy the requirement
    private int partition(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }

        int start = left;
        int end = right;
        int pivot = nums[(end + start) / 2];
        while (start <= end) {
            while (nums[start] < pivot && start <= end) {
                start++;
            }
            while (nums[end] > pivot && start <= end) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }


        if (k <= end) {
            return partition(nums, left, end, k);
        } else if (k >= start) {
            return partition(nums, start, right, k);
        }
        return nums[k];
    }
}