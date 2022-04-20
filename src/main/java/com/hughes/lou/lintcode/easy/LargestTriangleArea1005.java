package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-07
 */
public class LargestTriangleArea1005 implements Easy {
    /**
     * 由于点最多只有50个，直接枚举所有三角形即可
     *
     * @param points: List[List[int]]
     * @return: return a double
     */
    public double largestTriangleArea(int[][] points) {
        double max = 0.0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, areaCal(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    // 使用叉积计算三角形面积
    public double areaCal(int[] pt1, int[] pt2, int[] pt3) {
        return Math.abs(pt1[0] * (pt2[1] - pt3[1]) + pt2[0] * (pt3[1] - pt1[1]) + pt3[0] * (pt1[1] - pt2[1])) / 2.0;
    }
}
