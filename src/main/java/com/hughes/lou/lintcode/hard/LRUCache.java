/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.hughes.lou.lintcode.level.Hard;

/**
 * Created by Hughes on 2018/1/24 23:05.
 */
public class LRUCache implements Hard {
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

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public int get0(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put0(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
        } else {
            // 将新的 key 添加链表尾部
            cache.put(key, val);
            if (cache.size() > capacity) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
        }
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}