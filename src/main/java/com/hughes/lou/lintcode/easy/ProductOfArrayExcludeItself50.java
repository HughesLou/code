package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给定一个整数数组A。
 * 定义 B[i]=A[0]∗...∗A[i−1]∗A[i+1]∗...∗A[n−1]B[i]=A[0]∗...∗A[i−1]∗A[i+1]∗...∗A[n−1]，
 * 计算B的时候请不要使用除法。请输出B。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class ProductOfArrayExcludeItself50 implements Easy {

    /**
     * 分两次循环 第一次记录数组从后往前的累乘结果，fi代表i位之后所有元素的乘积 第二次循环，从左往右，跳过 i 左侧累乘，右侧直接乘以fi + 1
     *
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        int len = nums.size();
        ArrayList<Long> result = new ArrayList<>();
        long[] f = new long[len];

        long tmp = 1;
        long now = 1;
        f[len - 1] = nums.get(len - 1);
        int i;
        for (i = len - 2; i >= 0; --i) {
            f[i] = nums.get(i);
            f[i] = f[i] * f[i + 1];
        }

        for (i = 0; i < len; ++i) {
            now = tmp;
            if (i + 1 < len) {
                result.add(now * f[i + 1]);
            } else {
                result.add(now);
            }
            now = nums.get(i);
            tmp = tmp * now;

        }
        return result;
    }

    public List<Long> productExcludeItself0(List<Integer> nums) {
        int length = nums.size();
        List<Long> result = new ArrayList<>(length);
        long rs;
        for (int i = 0; i < length; i++) {
            rs = 1;
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    rs *= nums.get(j);
                }
            }
            result.add(rs);
        }
        return result;
    }
}
