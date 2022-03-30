package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class TotalOccurrenceOfTarget462 implements Easy {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int first = 0;
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        } else {
            return 0;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int last = 0;
        if (A[end] == target) {
            last = end;
        } else if (A[start] == target) {
            last = start;
        } else {
            return 0;
        }

        return last - first + 1;
    }
}
