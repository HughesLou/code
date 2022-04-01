package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class ImplementQueueByLinkedList492 implements Easy {
    LinkedList<Integer> list = new LinkedList<>();

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        list.add(item);
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        if (list.size() > 0) {
            return list.remove(0);
        } else {
            return -1;
        }
    }
}
