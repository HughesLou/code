package com.hughes.lou.lintcode.sort;


import java.util.Arrays;

import com.hughes.lou.lintcode.utils.Utils;

/**
 * @author HughesLou
 * Created on 2022-03-22
 */
public class ShellSort implements Sort {

    /**
     * 将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
     * 每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
     */
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int gap = array.length / 2;
        for (; gap > 0; gap = gap / 2) {
            for (int j = 0; (j + gap) < array.length; j++) { //不断缩小gap，直到1为止
                for (int k = 0; (k + gap) < array.length; k += gap) { //使用当前gap进行组内插入排序
                    if (array[k] > array[k + gap]) { //交换操作
                        //                        array[k] = array[k] + array[k + gap];
                        //                        array[k + gap] = array[k] - array[k + gap];
                        //                        array[k] = array[k] - array[k + gap];
                        Utils.swap(array, k, k + gap);
                        System.out.println("sorting--" + Arrays.toString(array));
                    }
                }
            }
        }
        return array;
    }
}