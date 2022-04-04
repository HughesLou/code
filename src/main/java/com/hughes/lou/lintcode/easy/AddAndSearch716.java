package com.hughes.lou.lintcode.easy;

import java.util.Arrays;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给出两个整型数组 inputs 和 tests，只要你能从 inputs 中挑出一对数字，
 * 令它们的和能够在 tests 被找到，就返回真；如果一对都找不到，则返回假。
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class AddAndSearch716 implements Easy {
    /**
     * @param inputs: an integer array
     * @param tests: an integer array
     * @return: return true if sum of two values in inputs are in tests.
     */
    public boolean addAndSearch(int[] inputs, int[] tests) {
        if (inputs.length <= 1) {
            return false;
        }

        Arrays.sort(inputs);

        for (int test : tests) {
            for (int i = 0, j = inputs.length - 1; i < j; ) {
                int sum = inputs[i] + inputs[j];
                if (sum == test) {
                    return true;
                } else if (sum > test) {
                    --j;
                } else {
                    ++i;
                }
            }
        }

        return false;
    }
}
