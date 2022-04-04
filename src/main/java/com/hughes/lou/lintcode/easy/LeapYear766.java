package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class LeapYear766 implements Easy {
    /**
     * @param n: a number represent year
     * @return: whether year n is a leap year.
     */
    public boolean isLeapYear(int n) {
        return n % 100 == 0 ? n % 400 == 0 : n % 4 == 0;
    }
}
