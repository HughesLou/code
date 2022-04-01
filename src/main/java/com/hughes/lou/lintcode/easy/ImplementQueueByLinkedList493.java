package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class ImplementQueueByLinkedList493 implements Easy {
    LinkedList<Integer> list;

    public ImplementQueueByLinkedList493() {
        list = new LinkedList<>();
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_front(int item) {
        list.add(0, item);
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_back(int item) {
        list.add(item);
    }

    /*
     * @return: An integer
     */
    public int pop_front() {
        return list.removeFirst();
    }

    /*
     * @return: An integer
     */
    public int pop_back() {
        return list.removeLast();
    }
}
