package com.hughes.lou.lintcode.easy;

/**
 * 给出一个包含 0 .. N 中 N 个数的序列，找出0 .. N 中没有出现在序列中的那个数。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class MissingNumber196 {

    /**
     * 异或
     *
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        for (int i = 0; i <= nums.length; i++) {
            res = res ^ i;
        }
        return res;
    }

    /**
     * 求和+减法
     */
    public int findMissing0(int[] nums) {
        int dsum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            dsum += i - nums[i];
        }
        return dsum;
    }
}
