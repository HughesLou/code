/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * Created by Hughes on 2018/1/20 16:28.
 */
public class CosineSimilarity445 implements Easy {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: Cosine similarity
     */
    public double cosineSimilarity(int[] A, int[] B) {
        if (null == A || null == B || A.length != B.length) {
            return 0;
        }
        double sum = 0;
        double sumA = 0;
        double sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[i];
            sumA += A[i] * A[i];
            sumB += B[i] * B[i];
        }
        if (0 == sumA || 0 == sumB) {
            return 2;
        }
        return sum / (Math.sqrt(sumA) * Math.sqrt(sumB));
    }
}
