/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hughes on 2018/1/24 23:05.
 */
public class LRUCache {
    // 保持当前缓存key
    public ArrayList<Integer> list = new ArrayList<>();
    // 缓存的实际值
    public HashMap<Integer, Integer> map = new HashMap<>();
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int ind = list.indexOf(key);
            list.remove(ind);
            list.add(0, key);
            return map.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            int ind = list.indexOf(key);
            list.remove(ind);
            list.add(0, key);
            map.put(key, value);
        } else {
            list.add(0, key);
            map.put(key, value);
            if (list.size() > capacity) {
                int rm = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                map.remove(rm);
            }
        }

    }
}
