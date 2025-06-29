package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给定两个排序后的区间序列，序列内每个区间两两互不相交，返回两个序列相交的区间的下标
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class Intersection295 implements Easy {

    /**
     * @param a: first sequence
     * @param b: second sequence
     * @return: return ans
     */
    public List<List<Integer>> Intersection(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> results = new ArrayList<>();

        int aIndex = 0, bIndex = 0, leftMax, rightMin;

        while (aIndex < a.size() && bIndex < b.size()) {
            leftMax = Math.max(a.get(aIndex).get(0), b.get(bIndex).get(0));
            rightMin = Math.min(a.get(aIndex).get(1), b.get(bIndex).get(1));

            if (leftMax <= rightMin) {
                List<Integer> intersection = new ArrayList<>();
                intersection.add(aIndex);
                intersection.add(bIndex);
                results.add(intersection);
            }

            if (rightMin == a.get(aIndex).get(1)) {
                aIndex++;
            } else {
                bIndex++;
            }
        }

        return results;
    }
}
