package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个长度为N的整数数组arr，返回去掉重复元素之后的数组（去掉重复元素前后数组元素相对次序不变）
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class UniqueArray296 implements Easy {

    /**
     * @param arr: a integer array
     * @return: return the unique array
     */
    public int[] getUniqueArray(int[] arr) {
        ArrayList<Integer> uniqueArray = new ArrayList<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();

        for (int j : arr) {
            if (!isVisited.containsKey(j)) {
                isVisited.put(j, true);
                uniqueArray.add(j);
            }
        }

        return uniqueArray.stream().mapToInt(Integer::valueOf).toArray();
    }
}
