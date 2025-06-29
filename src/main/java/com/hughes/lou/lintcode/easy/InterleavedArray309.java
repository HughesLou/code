package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 交叉数组
 * <p>
 * 给定两个相同长度的数组，通过取第一个数组的第一个元素，第二个数组的第一个元素，
 * 第一个数组的第二个元素...依此类推来交叉它们。返回新的交错数组。
 * 注意 ： 长度 ≤ 10000
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class InterleavedArray309 implements Easy {
    /**
     * @param A: the array A
     * @param B: the array B
     * @return: returns an alternate array of arrays A and B.
     */
    public int[] interleavedArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
        }
        return ans;
    }
}
