package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class ImplementStack495 implements Easy {
    private List<Integer> array = new ArrayList<>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        array.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        int length = array.size();
        if (length > 0) {
            array.remove(length - 1);
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        int length = array.size();
        return array.get(length - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
