package com.hughes.lou.lintcode.sort;


import java.util.Arrays;

/**
 * MSD（Most significant digital）
 * 从最左侧高位开始进行排序。先按k1排序分组, 同一组中记录, 关键码k1相等,
 * 再对各组按k2排序分成子组, 之后, 对后面的关键码继续这样的排序分组,
 * 直到按最次位关键码kd对各子组排序后.
 * 再将各组连接起来, 便得到一个有序序列。MSD方式适用于位数多的序列。
 * <p>
 * LSD（Least significant digital）
 * 从最右侧低位开始进行排序。先从kd开始排序，再对kd-1进行排序，
 * 依次重复，直到对k1排序后便得到一个有序序列。LSD方式适用于位数少的序列。
 *
 * @author HughesLou
 * Created on 2022-03-22
 */
public class RadixSort implements Sort {

    /**
     * 以LSD为例，从最低位开始，具体算法描述如下：
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("max=" + max);

        int maxDigit = 0;
        while (max != 0) {
            max = max / 10;
            maxDigit++;
        }
        System.out.println("maxDigit=" + maxDigit);

        int[][] buckets = new int[10][array.length];
        int base = 10;

        // 从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bucketLen = new int[10];  // 存储各个桶中存储元素的数量

            // 收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            for (int value : array) {
                int whichBucket = (value % base) / (base / 10);
                buckets[whichBucket][bucketLen[whichBucket]] = value;
                bucketLen[whichBucket]++;
            }

            int k = 0;
            // 收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            for (int l = 0; l < buckets.length; l++) {
                for (int m = 0; m < bucketLen[l]; m++) {
                    array[k++] = buckets[l][m];
                }
            }
            System.out.println("sorting--" + Arrays.toString(array));
            base *= 10;
        }

        return array;
    }
}