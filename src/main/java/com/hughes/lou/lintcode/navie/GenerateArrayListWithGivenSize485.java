package com.hughes.lou.lintcode.navie;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给你一个大小size,生成一个元素从1 到 size的数组
 *
 * @author HughesLou
 * Created on 2021-02-26
 */
public class GenerateArrayListWithGivenSize485 implements Easy {

    /**
     * @param ipLines: ip  address
     * @return: return highestFrequency ip address
     */
    public String highestFrequency(String[] ipLines) {
        Map<String, Integer> result = new HashMap<>();
        for (String ipLine : ipLines) {
            result.put(ipLine, result.getOrDefault(ipLine, 0) + 1);
        }
        return result.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
    }
}