package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class ValidTriangle765 implements Easy {
    /**
     * @param a: a integer represent the length of one edge
     * @param b: a integer represent the length of one edge
     * @param c: a integer represent the length of one edge
     * @return: whether three edges can form a triangle
     */
    public boolean isValidTriangle(int a, int b, int c) {
        return (a + b > c && b + c > a && c + a > b);
    }
}
