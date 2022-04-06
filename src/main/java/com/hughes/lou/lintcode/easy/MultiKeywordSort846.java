package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，表示为(学号，考试成绩)，
 * 请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class MultiKeywordSort846 implements Easy {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (!cmp(array[i], array[j])) {
                    int tmp = array[i][0];
                    array[i][0] = array[j][0];
                    array[j][0] = tmp;

                    tmp = array[i][1];
                    array[i][1] = array[j][1];
                    array[j][1] = tmp;
                }
            }
        }

        return array;
    }

    private boolean cmp(int[] a, int[] b) {
        return a[1] > b[1] || a[1] == b[1] && a[0] < b[0];
    }
}
