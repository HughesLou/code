/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode;

import java.util.Arrays;

/**
 * Created by Hughes on 2018/1/24 00:14.
 */
public class HeapSort {
    /**
     * 构建大顶堆
     */
    public static void adjustHeap(int[] a, int start, int end) {
        int temp, j;
        temp = a[start];
        for (j = 2 * start; j < end; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < end && a[j] < a[j + 1]) {
                ++j; // j为关键字中较大记录的下标
            }
            if (temp >= a[j]) {
                break;
            }
            a[start] = a[j];
            start = j;
        }
        a[start] = temp;
    }

    public static void heapSort(int[] a) {
        int start;
        for (start = a.length / 2 - 1; start >= 0; start--) {// 构建一个大顶堆
            adjustHeap(a, start, a.length - 1);
            System.out.println(Arrays.toString(a));
        }
        System.out.println("---------");
        for (start = a.length - 1; start >= 0; start--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[start];
            a[start] = temp;
            System.out.println(Arrays.toString(a));
            adjustHeap(a, 0, start - 1);// 将a中前i-1个记录重新调整为大顶堆
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
