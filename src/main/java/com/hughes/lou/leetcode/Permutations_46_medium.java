package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46_medium implements Medium {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(permuteList, visited, nums, ret);
        return ret;
    }

    private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret) {
        if (permuteList.size() == nums.length) {
            ret.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, visited, nums, ret);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
