package com.hughes.lou.lintcode.sort;

/**
 * @author HughesLou
 * Created on 2022-03-22
 */
public class InsertionSort implements Sort {

    /**
     * 插入排序都采用in-place在数组上实现。具体算法描述如下：
     * ①. 从第一个元素开始，该元素可以认为已经被排序
     * ②. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * ③. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * ④. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * ⑤. 将新元素插入到该位置后
     * ⑥. 重复步骤②~⑤
     */
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i]; // 先取出待插入数据保存，因为向后移位过程中会把覆盖掉待插入数
            while (j >= 0 && array[j] > temp) { // 如果待是比待插入数据大，就后移
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp; // 找到比待插入数据小的位置，将待插入数据插入
        }
        return array;
    }
}