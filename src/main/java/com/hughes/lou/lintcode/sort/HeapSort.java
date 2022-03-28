/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.hughes.lou.lintcode.utils.ObjectMapperUtils;
import com.hughes.lou.lintcode.utils.Utils;

/**
 * 堆是具有以下性质的完全二叉树，每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 * 或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * <p>
 * Created by Hughes on 2018/1/24 00:14.
 */
public class HeapSort implements Sort {

    /**
     * 将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
     * 将其与末尾元素进行交换，此时末尾就为最大值。
     * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
     * 如此反复执行，便能得到一个有序序列了
     */
    @Override
    public int[] sort(int[] array) {
        int start;
        // 构建一个大顶堆
        for (start = array.length / 2 - 1; start >= 0; start--) {
            adjustHeap(array, start, array.length - 1);
            System.out.println(Arrays.toString(array));
        }
        System.out.println("---------");
        // 将堆顶记录和当前未经排序子序列的最后一个记录交换
        for (start = array.length - 1; start >= 0; start--) {
            Utils.swap(array, 0, start);
            System.out.println(Arrays.toString(array));
            // 将a中前i-1个记录重新调整为大顶堆
            adjustHeap(array, 0, start - 1);
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 构建大顶堆
     */
    public void adjustHeap(int[] array, int start, int end) {
        int temp, j;
        temp = array[start];
        for (j = 2 * start; j < end; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < end && array[j] < array[j + 1]) {
                ++j; // j为关键字中较大记录的下标
            }
            if (temp >= array[j]) {
                break;
            }
            array[start] = array[j];
            start = j;
        }
        array[start] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        for (String element : input.split(" ")) {
            list.add(Integer.parseInt(element));
        }

        int[] array = ArrayUtils.toPrimitive(list.toArray(new Integer[0]));

        System.out.println(ObjectMapperUtils.toJSON(array));
        new HeapSort().sort(array);
        System.out.println(ObjectMapperUtils.toJSON(array));
    }
}
