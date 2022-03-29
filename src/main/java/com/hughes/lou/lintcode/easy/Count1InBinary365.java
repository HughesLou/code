package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-29
 */
public class Count1InBinary365 implements Easy {

    /**
     * @param num: An integer
     * @return: An integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;
        for (int i = 0; num != 0 && i < 32; ++i) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }

    public int countOnes1(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
