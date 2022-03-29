package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 班上的学生根据他们的年级照片的身高升序排列，确定当前未站在正确位置的学生人数
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class OrderCheck334 implements Easy {

    /**
     * @param heights: Students height
     * @return: How many people are not where they should be
     */
    public int orderCheck(List<Integer> heights) {
        List<Integer> after = new ArrayList<>(heights);
        Collections.sort(after);
        int count = 0;
        for (int i = 0; i < after.size(); i++) {
            if (heights.get(i) != after.get(i)) {
                count++;
            }
        }
        return count;
    }
}
