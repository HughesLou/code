/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

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
        dummy.next = head;

        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            // move to next pair
            head = n1;
        }

        return dummy.next;
    }
}
