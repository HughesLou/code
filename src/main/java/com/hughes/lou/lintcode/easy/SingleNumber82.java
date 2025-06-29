package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给出 2 * n + 1个数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class SingleNumber82 implements Easy {

    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }
}
