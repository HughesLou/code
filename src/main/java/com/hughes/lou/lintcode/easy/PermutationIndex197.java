/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by Hughes on 2018/1/19 22:25.
 */
public class PermutationIndex197 implements Easy {
    /**
     * 看做是多个数字组成的一个数，然后比较大小
     *
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        long R = 0;
        int low[] = new int[A.length];
        long weight[] = new long[A.length];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[i]) {
                    ++low[i];
                }
            }
            weight[i] = (i >= A.length - 2) ? (A.length - 1 - i) : weight[i + 1] * (A.length - i - 1);

            R += weight[i] * low[i];
        }
        return R + 1;
    }
}
