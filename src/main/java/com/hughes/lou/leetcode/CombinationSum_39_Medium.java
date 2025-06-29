package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39_Medium implements Medium {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        doCombination(candidates, target, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void doCombination(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                doCombination(candidates, target - candidates[i], i, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] ca = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new CombinationSum_39_Medium().combinationSum(ca, target);
        System.out.println(result);
    }
}
