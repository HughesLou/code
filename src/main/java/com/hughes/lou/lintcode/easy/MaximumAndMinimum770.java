package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class MaximumAndMinimum770 implements Easy {
    /**
     * @param matrix: an input matrix
     * @return: nums[0]: the maximum,nums[1]: the minimum
     */
    public int[] maxAndMin(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                result[0] = Math.max(result[0], element);
                result[1] = Math.min(result[1], element);
            }
        }
        return result;
    }
}
