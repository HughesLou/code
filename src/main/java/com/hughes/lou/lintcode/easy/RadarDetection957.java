package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.Point;

/**
 * 一个2D平面上有一堆雷达（雷达有x, y坐标，以及能探测到的范围r半径）。
 * 现在有一辆小车要从y = 0和y = 1的区间里面通过并且不能被雷达探测到。
 * 若被检测到，输出YES，否则输出NO。
 * （可以认为，小车是一条长度为1的线段，沿直线从x = 0 向右前进）
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class RadarDetection957 implements Easy {

    /**
     * 对于每个雷达，判断是否能检测到（0,1）区域
     *
     * @param coordinates: The radars coordinate
     * @param radius: Detection radius of radars
     * @return: The car was detected or not
     */
    public String radarDetection(Point[] coordinates, int[] radius) {
        int flag = 0;
        for (int i = 0; i < coordinates.length; i++) {
            int low = coordinates[i].y - radius[i];
            int high = coordinates[i].y + radius[i];
            if (high > 0 && low < 0 || low < 1 && high > 1) {
                flag = 1;
                break;
            }
        }
        return flag == 0 ? "NO" : "YES";
    }
}
