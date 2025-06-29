package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.Point;

/**
 * 给一个<Point>的List p，求满足p[i].x+p[j].x和p[i].y+p[j].y（i < j)都能被2整除的(i,j)对数。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class NumberPairStatistics844 implements Easy {
    /**
     * a,b,c,d为point数组中（奇数，偶数）,（奇数，奇数）,（偶数，偶数）,（偶数，奇数）四种情况的数量。
     * （奇数，偶数）与（奇数，偶数）组合，（奇数，奇数）与（奇数，奇数）组合，
     * （偶数，偶数）与（偶数，偶数）组合，（偶数，奇数）与（偶数，奇数）组合，
     * 即答案为 ans = ((a - 1) * a + (b - 1) * b + (c - 1) * c + (d - 1) * d) / 2。
     *
     * @param p: the point List
     * @return: the numbers of pairs which meet the requirements
     */
    public int pairNumbers(Point[] p) {
        int oo = 0, oe = 0, eo = 0, ee = 0;
        for (Point point : p) {
            if ((point.x & 1) == 0) {
                if ((point.y & 1) == 0) {
                    ee++;
                } else {
                    eo++;
                }
            } else {
                if ((point.y & 1) == 0) {
                    oe++;
                } else {
                    oo++;
                }
            }
        }
        int ans = 0;
        ans += oo * (oo - 1);
        ans += oe * (oe - 1);
        ans += eo * (eo - 1);
        ans += ee * (ee - 1);
        return ans >> 1;
    }

}
