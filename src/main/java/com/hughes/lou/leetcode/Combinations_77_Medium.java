package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77_Medium implements Medium {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(1, n, k, combineList, ret);
        return ret;
    }

    private void backtracking(int start, int n, int k, List<Integer> combineList, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList<>(combineList)); // 这里要重新构造一个 List
            return;
        }

        for (int i = start; i <= n - k + 1; i++) { // 剪枝
            combineList.add(i);                        // 把 i 标记为已访问
            backtracking(i + 1, n, k - 1, combineList, ret);
            combineList.remove(combineList.size() - 1); // 把 i 标记为未访问
        }
    }
}
