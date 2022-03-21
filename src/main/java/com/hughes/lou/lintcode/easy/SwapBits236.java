package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 交换奇偶二进制位
 * <p>
 * 设计一个方法，用尽可能少的指令，将一个整数中奇数数位和偶数数位的数字交换
 * （如，数位 0 和数位 1 交换，数位 2 和数位 3 交换，等等）。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class SwapBits236 implements Easy {

    /**
     * @param x an integer
     * @return an integer
     */
    public int swapOddEvenBits(int x) {
        // Write your code here
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }
}
