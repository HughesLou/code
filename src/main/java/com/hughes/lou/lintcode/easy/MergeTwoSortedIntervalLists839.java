package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.Interval;

/**
 * 合并两个已排序的区间列表，并将其作为一个新的有序区间列表返回。
 * 新的区间列表应该通过拼接两个列表的区间并按升序排序。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class MergeTwoSortedIntervalLists839 implements Easy {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        List<Interval> result = new ArrayList<>();
        int len1 = list1.size();
        int len2 = list2.size();
        int p1 = 0;
        int p2 = 0;

        while (p1 < len1 && p2 < len2) {
            Interval item1 = list1.get(p1);
            Interval item2 = list2.get(p2);
            if (item1.end < item2.start) {
                result.add(item1);
                p1++;
            } else if (item2.end < item1.start) {
                result.add(item2);
                p2++;
            } else {
                if (item1.end > item2.end) {
                    // 修改记录中的起止值
                    item1.start = Math.min(item1.start, item2.start);
                    p2++;
                } else {
                    item2.start = Math.min(item1.start, item2.start);
                    p1++;
                }
            }
        }

        while (p1 < len1) {
            result.add(list1.get(p1++));
        }
        while (p2 < len2) {
            result.add(list2.get(p2++));
        }
        return result;
    }
}
