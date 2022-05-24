package com.hughes.lou.lintcode.medium;

import com.hughes.lou.lintcode.level.Medium;

/**
 * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。
 * 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * <p>
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *
 * @author HughesLou
 * Created on 2022-05-21
 */
public class HouseRobber392 implements Medium {

    /**
     * @param a: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] a) {
        int n = a.length;
        // 记录 dp[i+1] 和 dp[i+2]
        long dp1 = 0, dp2 = 0;
        // 记录 dp[i]
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(dp1, a[i] + dp2);
            dp2 = dp1;
            dp1 = res;
        }
        return res;
    }
}