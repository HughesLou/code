package com.hughes.lou.lintcode.medium;

import com.hughes.lou.lintcode.level.Medium;

/**
 * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 *
 * @author HughesLou <luzhiwei@kuaishou.com>
 * Created on 2021-02-26
 */
public class DigitCounts3 implements Medium {

    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
        }
        return cnt;
    }

    public int singleCount(int i, int k) {
        if (i == 0 && k == 0) {
            return 1;
        }
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) {
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }
}