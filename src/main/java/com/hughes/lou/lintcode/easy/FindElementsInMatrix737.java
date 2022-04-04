/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.hughes.lou.lintcode.level.Easy;

/**
 * Created by Hughes on 2018/1/20 20:47.
 */
public class FindElementsInMatrix737 implements Easy {
    /**
     * @param Matrix: the input
     * @return: the element which appears every row
     */
    public int FindElements(int[][] Matrix) {
        boolean exist = false;
        for (int i = 0; i < Matrix[0].length; i++) {
            for (int j = 1; j < Matrix.length; j++) {
                if (has(Matrix[0][i], Matrix[j])) {
                    exist = true;
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
        for (int j : array) {
            if (a == j) {
                return true;
            }
        }
        return false;
    }

    public int FindElements1(int[][] matrix) {
        int w = matrix[0].length;
        int l = matrix.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            list.add(matrix[0][i]);
        }
        for (int i = 1; i < l; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < w; j++) {
                set.add(matrix[i][j]);
            }
            for (int j = 0; j < list.size(); j++) {
                if (!set.contains(list.get(j))) {
                    list.remove(list.get(j));
                }
            }
        }
        return list.get(0);
    }
}
