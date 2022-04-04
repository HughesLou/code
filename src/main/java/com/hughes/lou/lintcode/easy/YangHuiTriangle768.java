package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class YangHuiTriangle768 implements Easy {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public List<List<Integer>> calcYangHuisTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        int i, j;
        for (i = 0; i < n; ++i) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (j = 1; j < i; ++j) {
                line.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }

            if (i > 0) {
                line.add(1);
            }

            result.add(line);
        }

        return result;
    }
}
