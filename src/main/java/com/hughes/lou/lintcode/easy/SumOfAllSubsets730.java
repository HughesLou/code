package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class SumOfAllSubsets730 implements Easy {

    /**
     * 找规律可以发现，每个数出现2^(n - 1)次
     *
     * @param n: the given number
     * @return: Sum of elements in subsets
     */
    public int subSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i++;
        }
        return (int) (sum * Math.pow(2, (n - 1)));
    }
}