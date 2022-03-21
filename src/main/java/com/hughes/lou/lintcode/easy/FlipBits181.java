package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 如果要将整数n转换为m，需要改变多少个bit位？
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class FlipBits181 implements Easy {

    /**
     * a ^ b 得到的结果的二进制中，1的个数就是a和b相异的位数
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >>> 1) {
            count += c & 1;
        }
        return count;
    }
}
