package com.hughes.lou.lintcode.navie;

import com.hughes.lou.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class Max3Numbers283 implements Naive {

    public int maxOfThreeNumbers(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}
