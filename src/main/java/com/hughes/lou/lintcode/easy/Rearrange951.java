package com.hughes.lou.lintcode.easy;

import java.util.Arrays;

import com.hughes.lou.level.Easy;

/**
 * 给一列数组要求重排，必须所有偶数位上的数都小于所有奇数位上的数。
 * 同时，偶数位上的数也按照升序排序，奇数位上的也按照升序排序。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class Rearrange951 implements Easy {
    /**
     * @param nums: the num arrays
     * @return: the num arrays after rearranging
     */
    public int[] rearrange(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0;
        Arrays.sort(nums);
        for (int i = 0; i < ans.length; i += 2) {
            ans[i] = nums[pos++];
        }
        for (int i = 1; i < ans.length; i += 2) {
            ans[i] = nums[pos++];
        }
        return ans;
    }
}
