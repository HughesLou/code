package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 写出一个高效的算法来搜索 m × n矩阵中的值 target 。
 * <p>
 * 这个矩阵具有以下特性：
 * <p>
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class SearchA2DMatrix28 implements Easy {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }

        // find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else {
            return matrix[row][end] == target;
        }
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = n * col - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            int middleValue = matrix[mid / col][mid % col];
            if (middleValue == target) {
                return true;
            } else if (middleValue > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return matrix[right / col][right % col] == target;
    }
}
