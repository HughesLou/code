package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 在一条直的马路上，有n 棵树，每棵树有一个坐标，代表它们距离马路起点的距离。
 * 如果每相邻的两棵树之间的间隔不小于d，那么我们认为这些树是美观的。
 * 请计算出最少移除多少棵树，可以让这些树变得美观。
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class TreePlanning358 implements Easy {
    /**
     * @param trees: the positions of trees.
     * @param d: the minimum beautiful interval.
     * @return: the minimum number of trees to remove to make trees beautiful.
     */
    public int treePlanning(int[] trees, int d) {
        int count = 0;
        int cur = trees[0];
        for (int i = 1; i < trees.length; i++) {
            if (trees[i] - cur < d) {
                count ++;
            } else {
                cur = trees[i];
            }
        }
        return count;
    }
}
