/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * Created by Hughes on 2018/1/20 20:27.
 */
public class CheckSumOfSquareNumbers697 implements Easy {
    /*
     * @param : the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int num) {
        if (0 > num) {
            return false;
        }
        int a = (int) Math.sqrt(num);

        int left = 0;
        for (int i = 0; i <= a; i++) {
            left = num - i * i;
            if (left == Math.pow((int) Math.sqrt(left), 2)) {
                return true;
            }
        }
        return false;
    }
}
