package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 你有 n 枚硬币，想要摆放成阶梯形状，即第 k 行恰好有 k 枚硬币。
 * 给出 n，找到可以形成的完整楼梯行数。
 * n 是一个非负整数，且在32位有符号整数范围内。
 *
 * @author HughesLou
 * Created on 2022-04-07
 */
public class ArrangingCoins988 implements Easy {
    /**
     * @param n: a non-negative integer
     * @return: the total number of full staircase rows that can be formed
     */
    public int arrangeCoins(int n) {
        int level = 1;
        while (n > 0) {
            n -= level;
            level++;
            if (n < level) {
                return level - 1;
            }
        }
        return level - 1;
    }
}
