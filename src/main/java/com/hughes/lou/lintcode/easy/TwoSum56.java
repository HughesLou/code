package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class TwoSum56 implements Easy {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // 用一个hashmap来记录，key记录target-numbers[i]的值，value记录numbers[i]的i的值，如果碰到一个
        // numbers[j]在hashmap中存在，那么说明前面的某个numbers[i]和numbers[j]的和为target，i和j即为答案
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                return new int[] {map.get(numbers[i]), i};
            }
            map.put(target - numbers[i], i);
        }

        return new int[] {};
    }

    List<int[]> twoSumTarget(int[] nums, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        List<int[]> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                res.add(new int[] {left, right});
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }
}
