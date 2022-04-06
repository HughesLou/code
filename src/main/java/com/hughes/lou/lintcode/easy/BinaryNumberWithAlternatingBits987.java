package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给一个正整数，检查它的二进制表示是否具有交替位。即，两个相邻的位总是具有不同的值。
 *
 * @author HughesLou
 * Created on 2022-04-07
 */
public class BinaryNumberWithAlternatingBits987 implements Easy {
    /**
     * 对于一个具有交替位的二进制数，我们把它右移一位后与原二进制数异或，得到的新二进制数每一位上都是1。
     * <p>
     * 例如10101 ^ 1010 = 11111 所以我们把问题转化为了如何判断一个二进制数是否每一位全为1
     * 这里我们采用的方法是将该二进制数+1后与原数进行与操作
     * 如果结果为0,则这个二进制数每一位全为1 例如 11111 ^ 100000 = 0
     *
     * @param n: a postive Integer
     * @return: if two adjacent bits will always have different values
     */
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}
