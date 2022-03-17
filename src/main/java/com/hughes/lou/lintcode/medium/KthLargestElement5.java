package com.hughes.lou.lintcode.medium;

import com.hughes.lou.lintcode.level.Medium;

/**
 * 在数组中找到第 k 大的元素。
 *
 * @author HughesLou
 * Created on 2021-02-26
 */
public class KthLargestElement5 implements Medium {

    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // 为了方便编写代码，这里将第 k 大转换成第 k 小问题。
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
