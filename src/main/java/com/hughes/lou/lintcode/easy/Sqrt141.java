package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-19
 */
public class Sqrt141 implements Easy {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end == x / end) {
            return end;
        } else {
            return start;
        }
    }
}
