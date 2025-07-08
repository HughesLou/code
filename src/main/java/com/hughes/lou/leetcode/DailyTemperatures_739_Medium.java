package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.Stack;

public class DailyTemperatures_739_Medium implements Medium {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.add(i);
        }
        return result;
    }
}
