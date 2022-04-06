package com.hughes.lou.lintcode.easy;

import java.util.Arrays;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给一个有 2n 个整数的数组，你的任务是把这些整数分成 n 组，
 * 如(a1, b1)，(a2, b2)，...，(an, bn)。并且使得 i 从 1 到 n 的 min(ai, bi)之和尽可能的大。
 *
 * @author HughesLou
 * Created on 2022-04-07
 */
public class ArrayPartitionI993 implements Easy {
    /**
     * @param nums: an array
     * @return: the sum of min(ai, bi) for all i from 1 to n
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
