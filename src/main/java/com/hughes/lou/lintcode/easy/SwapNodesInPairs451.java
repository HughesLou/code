/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * Created by Hughes on 2018/1/20 16:44.
 */
public class SwapNodesInPairs451 implements Easy {

    /*
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // swap-nodes-in-pairs
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);

        head = dummy;
        while (head.getNext() != null && head.getNext().getNext() != null) {
            ListNode n1 = head.getNext(), n2 = head.getNext().getNext();
            // head->n1->n2->...
            // => head->n2->n1->...
            head.setNext(n2);
            n1.setNext(n2.getNext());
            n2.setNext(n1);

            // move to next pair
            head = n1;
        }

        return dummy.getNext();
    }
}
