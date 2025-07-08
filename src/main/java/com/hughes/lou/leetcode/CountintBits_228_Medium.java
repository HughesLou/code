package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class CountintBits_228_Medium implements Medium {

    public int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public int countBits2(int n) {
        int[] ret = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i & (i - 1)] + 1;
        }
        return ret[n];
    }
}
