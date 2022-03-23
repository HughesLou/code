package com.hughes.lou.lintcode.sort;


import java.util.Arrays;

/**
 * @author HughesLou
 * Created on 2022-03-22
 */
public class MergeSort implements Sort {

    /**
     * 采用递归法：
     * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     * ③. 重复步骤②，直到所有元素排序完毕
     */
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int middle = array.length >> 1;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return mergeTwoArray(sort(left), sort(right));
    }

    public int[] mergeTwoArray(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        // 申请额外空间保存归并之后数据
        int[] result = new int[a.length + b.length];

        //选取两个序列中的较小值放入新数组
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        // 序列a中多余的元素移入新数组
        while (i < a.length) {
            result[k++] = a[i++];
        }
        // 序列b中多余的元素移入新数组
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }
}