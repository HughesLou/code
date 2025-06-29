package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给一串名字，将他们去重之后返回。两个名字重复是说在忽略大小写的情况下是一样的。
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class NameDeduplication487 implements Easy {
    /**
     * @param names: a string array
     * @return: a string array
     */
    public List<String> nameDeduplication(String[] names) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        for (String name : names) {
            String str = name.toLowerCase();
            if (!mp.containsKey(str)) {
                mp.put(str, 1);
                result.add(str);
            }
        }
        return result;
    }
}
