package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-07
 */
public class SubdomainVisitCount1006 implements Easy {
    /**
     * @param cpdomains: a list cpdomains of count-paired domains
     * @return: a list of count-paired domains
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            String[] line = str.split(" ");
            int count = Integer.parseInt(line[0]);
            String[] domains = line[1].split("\\.");
            String temp = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                temp = domains[i] + (temp.equals("") ? "" : "." + temp);
                map.put(temp, map.getOrDefault(temp, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (String str : map.keySet()) {
            res.add(map.get(str) + " " + str);
        }
        return res;
    }
}