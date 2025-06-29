/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.Interval;

/**
 * 给出若干闭合区间，合并所有重叠的部分。
 * <p>
 * Created by hughes on 2017/12/24 22:31.
 */
public class MergeIntervals156 implements Easy {
    /*
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));

        List<Interval> result = new ArrayList<>();

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                result.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end);
            }
        }
        return result;
    }
}
