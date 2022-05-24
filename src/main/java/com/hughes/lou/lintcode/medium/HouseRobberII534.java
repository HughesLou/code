package com.hughes.lou.lintcode.medium;

import com.hughes.lou.lintcode.level.Medium;

/**
 * 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，
 * 但这次所有的房子围成了一个圈，这就意味着第一间房子和最后一间房子是挨着的。
 * 每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，
 * 且当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * <p>
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *
 * @author HughesLou
 * Created on 2022-05-21
 */
public class HouseRobberII534 implements Medium {

    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {
        int dp1 = 0, dp2 = 0;
        int res = 0;
        for (int i = end; i >= start; i--) {
            res = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = res;
        }
        return res;
    }
}