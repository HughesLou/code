package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-27
 */
public class MaximumNonNegativeSubarray265 implements Easy {
    /**
     * @param A: an integer array
     * @return: return maxium contiguous non-negative subarray sum
     */
    public int maxNonNegativeSubArray(int[] A) {
        int maxSum = -1, curSum = 0;
        for (int i : A) {
            if (i >= 0) {
                curSum += i;
                // 更新最大子数组之和
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            } else {
                curSum = 0;
            }
        }
        return maxSum;
    }
}