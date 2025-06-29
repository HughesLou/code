package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给一个方程：ax2 + bx + c = 0，求根。
 * <p>
 * 如果方程有两个根，就返回一个包含两个根的数组/列表。
 * 如果方程只有一个根，就返回一个包含一个跟的数组/列表。
 * 如果方程没有根，就返回一个空数组/列表。
 *
 * @author HughesLou
 * Created on 2022-03-21
 */
public class RootOfEquation239 implements Easy {

    /**
     * @param a: parameter of the equation
     * @param b: parameter of the equation
     * @param c: parameter of the equation
     * @return: a double array, contains at most two root
     */
    public double[] rootOfEquation(double a, double b, double c) {
        double exp = b * b - 4 * a * c;
        if (exp < 0) {
            return new double[0];
        }

        if (exp == 0) {
            double[] root = new double[1];
            root[0] = -b / 2.0 / a;
            return root;
        }

        double[] root = new double[2];
        double delta = Math.sqrt(exp);
        root[0] = (-b - delta) / 2.0 / a;
        root[1] = (-b + delta) / 2.0 / a;

        if (root[0] > root[1]) {
            double temp = root[0];
            root[0] = root[1];
            root[1] = temp;
        }
        return root;
    }
}
