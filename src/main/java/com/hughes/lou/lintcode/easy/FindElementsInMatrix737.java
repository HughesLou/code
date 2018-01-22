/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

/**
 * Created by Hughes on 2018/1/20 20:47.
 */
public class FindElementsInMatrix737 {
    /**
     * @param Matrix: the input
     *
     * @return: the element which appears every row
     */
    public int FindElements(int[][] Matrix) {
        // write your code here
        boolean exist = false;
        for (int i = 0; i < Matrix[0].length; i++) {
            for (int j = 1; j < Matrix.length; j++) {
                if (has(Matrix[0][i], Matrix[j])) {
                    exist = true;
                    continue;
                } else {
                    exist = false;
                    break;
                }
            }
            if (exist) {
                return Matrix[0][i];
            }
        }
        return 0;
    }

    private boolean has(int a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (a == array[i]) {
                return true;
            }
        }
        return false;
    }
}
