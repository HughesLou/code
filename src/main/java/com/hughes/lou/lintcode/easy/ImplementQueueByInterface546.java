package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class ImplementQueueByInterface546 implements Easy {
    private List<Integer> list;

    /* you can declare your private attributes here */
    public ImplementQueueByInterface546() {
        list = new ArrayList<>();
    }

    // implement the push method
    public void push(int val) {
        list.add(val);
    }

    // implement the pop method
    public int pop() {
        return list.remove(0);
    }

    // implement the top method
    public int top() {
        return list.get(0);
    }
}