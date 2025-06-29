package com.hughes.lou.lintcode.easy;

import java.util.Scanner;

import com.hughes.lou.level.Easy;

/**
 * 一个小孩爬一个 n 层台阶的楼梯。他可以每次跳 1 步， 2 步 或者 3 步。实现一个方法来统计总共有多少种不同的方式爬到最顶层的台阶。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class ClimbingStairs272 implements Easy {
    /**
     * 爬到第i阶可能有3种情况：
     * 在第i-1阶后爬1阶
     * 在第i-2阶后爬2阶
     * 在第i-3阶后爬3阶
     * 所以到达第i阶的方法数是这三种情况之和。
     * 令 dp[i] 表示能到达第i阶的方法总数，那么有： $
     * 为了节省空间，可以循环利用变量，计算第i位时，只保存该位数的前三位数字。
     *
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 1, c = 2;
        for (int i = 3; i < n + 1; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        ClimbingStairs272 climbingStairs272 = new ClimbingStairs272();
        System.out.println(climbingStairs272.climbStairs2(a));
    }
}
