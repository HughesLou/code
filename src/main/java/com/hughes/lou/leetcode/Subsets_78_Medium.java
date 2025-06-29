package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78_Medium implements Medium {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> subsetList = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtracking(0, i, nums, ret, subsetList);
        }
        return ret;
    }

    private void backtracking(int startIdx, int size, int[] nums, List<List<Integer>> ret, List<Integer> subsetList) {
        if (subsetList.size() == size) {
            ret.add(new ArrayList<>(subsetList));
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            subsetList.add(nums[i]);
            backtracking(i + 1, size, nums, ret, subsetList); // startIdx 设为下一个元素，使 subset 中的元素都递增排序
            subsetList.remove(subsetList.size() - 1);
        }
    }
}
