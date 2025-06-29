package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.Point;

/**
 * @author HughesLou
 * Created on 2022-04-01
 */
public class RectangleOverlap626 implements Easy {
    /**
     * @param l1: top-left coordinate of first rectangle
     * @param r1: bottom-right coordinate of first rectangle
     * @param l2: top-left coordinate of second rectangle
     * @param r2: bottom-right coordinate of second rectangle
     * @return: true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if (l1.x > r2.x || r1.x < l2.x) {
            return false;
        }
        return l1.y >= r2.y && r1.y <= l2.y;
    }
}
