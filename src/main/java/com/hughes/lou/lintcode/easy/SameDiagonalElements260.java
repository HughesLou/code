package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个 n * n 的矩阵，如果每一条从左上到右下的斜线上的数值相同，返回 true， 否则返回false。
 * 例如：
 * 1，2，3
 * 5，1，2
 * 6，5，1
 * 应该返回 true。
 * <p>
 * 但
 * 1，2，3
 * 2，1，5
 * 6，5，1
 * 应该返回 false。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class SameDiagonalElements260 implements Easy {

    /**
     * 和左上方的相比
     *
     * @param matrix: a matrix
     * @return: return true if same.
     */
    public boolean judgeSame(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
