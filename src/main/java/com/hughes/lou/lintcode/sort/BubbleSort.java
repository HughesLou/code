package com.hughes.lou.lintcode.sort;


import com.hughes.lou.utils.Utils;

/**
 * @author HughesLou
 * Created on 2022-03-22
 */
public class BubbleSort implements Sort {

    /**
     * 过程如下：
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     */
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int length = array.length;
        // 外层：需要length-1次循环比较
        for (int i = 0; i < length - 1; i++) {
            boolean swap = false;
            // 内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //交换数组array的j和j+1位置的数据
                    Utils.swap(array, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return array;
    }
}