package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class SubarraySumEqualsK838 implements Easy {
    /**
     * 首先求出nums的前缀和数组 然后将前缀和数组扫一遍，每扫到一个位置就将答案加上(prefixSum-k)在Hashmap中的出现次数
     * 在Hashmap中将当前前缀和prefixSum在出现的次数+1
     *
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        // 前缀和
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;
        sumMap.put(0, 1);

        for (int prefixSum : nums) {
            // 相差为k的两个前缀和
            if (sumMap.containsKey(prefixSum - k)) {
                count += sumMap.get(prefixSum - k);
            }
            sumMap.put(prefixSum, sumMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
