package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class KthSmallestElementInSortedMatrix_378_Medium implements Medium {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int i = n - 1, j = 0; // 从左下角开始

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
