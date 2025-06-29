package com.hughes.lou.lintcode.navie;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2021-02-26
 */
public class SwapTwoIntegersInArray484 implements Easy {

    /**
     * @param A: An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}