/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.Interval;

/**
 * Created by hughes on 2017/12/24 22:31.
 */
public class MergeIntervals156 implements Easy {
    /*
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals, new IntervalComparator());

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

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
