package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，爬到顶部的方法有多少种？
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class ClimbingStairs111 implements Easy {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

    public int climbStairs0(int n) {
        // write your code here
        if (n <= 2) {
            return n;
        }

        return climbStairs0(n - 2) + climbStairs0(n - 1);
    }
}
