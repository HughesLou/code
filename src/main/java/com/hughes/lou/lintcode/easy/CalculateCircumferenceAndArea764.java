package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class CalculateCircumferenceAndArea764 implements Easy {
    /**
     * @param r: a Integer represent radius
     * @return: the circle's circumference nums[0] and area nums[1]
     */
    public double[] calculate(int r) {
        double[] a = new double[2];
        a[0] = 2 * 3.14 * r;
        a[1] = 3.14 * r * r;
        return a;
    }
}