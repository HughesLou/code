package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个字符串数组lines, 每一个元素代表一个IP地址，找到出现频率最高的IP
 *
 * @author HughesLou
 * Created on 2021-02-26
 */
public class HighestFrequencyIP1613 implements Easy {

    /**
     * @param size: An integer
     * @return: An integer list
     */
    public List<Integer> generate(int size) {
        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; ) {
            result.add(++i);
        }
        return result;
    }
}