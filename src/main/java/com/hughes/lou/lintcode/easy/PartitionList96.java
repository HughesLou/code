/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * Created by hughes on 2017/12/17 23:23.
 */
public class PartitionList96 implements Easy {

    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftTemp = left, rightTemp = right;
        while (null != head) {
            if (head.getVal() < x) {
                leftTemp.setNext(head);
                leftTemp = leftTemp.getNext();
            } else {
                rightTemp.setNext(head);
                rightTemp = rightTemp.getNext();
            }
            head = head.getNext();
        }
        rightTemp.setNext(null);
        leftTemp.setNext(right.getNext());
        return left.getNext();
    }
}
