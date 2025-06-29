package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 完全平方数
 * <p>
 * 给出一个正整数 num,写一个函数，要求当这个当num为完全平方数时函数返回True，否则返回False
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class ValidPerfectSquare777 implements Easy {

    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     */
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            long value = (long) mid * mid;
            if (value == num) {
                return true;
            } else if (value < num) {
                l = mid;
            } else {
                r = mid;
            }
        }

        long ans = l;
        if (l * l < num) {
            ans = r;
        }
        return ans * ans == num;
    }

    public boolean isPerfectSquare1(int num) {
        int start = 1;
        int end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = num / mid;
            if (num % mid == 0 && val == mid) {
                return true;
            } else if (val > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}