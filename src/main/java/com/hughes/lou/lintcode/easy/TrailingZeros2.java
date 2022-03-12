package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 计算出n阶乘中尾部零的个数
 *
 * @author HughesLou <luzhiwei@kuaishou.com>
 * Created on 2021-02-26
 */
public class TrailingZeros2 implements Easy {

    /*
     * param n: As description
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // 取决于5的个数
        long sum = 0;
        while (n != 0) {
            n /= 5;
            sum += n;
        }
        return sum;
    }
}
