package com.hughes.lou.lintcode.sort;

import com.hughes.lou.lintcode.utils.Utils;

/**
 * @author HughesLou
 * Created on 2022-03-22
 */
public class SelectionSort implements Sort {

    /**
     * ①. 从待排序序列中，找到关键字最小的元素；
     * ②. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * ③. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     */
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            // 选出之后待排序中值最小的位置
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                //                array[min] = array[i] + array[min];
                //                array[i] = array[min] - array[i];
                //                array[min] = array[min] - array[i];
                Utils.swap(array, i, min);
            }
        }
        return array;
    }
}