package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-01
 */
public class TwoSum607 implements Easy {
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        list.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer element : list) {
            int num = value - element;
            if ((element == num && map.get(element) > 1) || (element != num && map.containsKey(num))) {
                return true;
            }
        }
        return false;
    }
}
