package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class SumOfSquareNumbers697 implements Easy {
    /**
     * @param num: the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int num) {
        if (num < 0) {
            return false;
        }

        int left = 0;
        int right = (int) Math.sqrt(num);
        while (left <= right) {
            int sumProducts = left * left + right * right;
            if (sumProducts > num) {
                --right;
            } else if (sumProducts < num) {
                ++left;
            } else {
                return true;
            }
        }
        return false;
    }
}