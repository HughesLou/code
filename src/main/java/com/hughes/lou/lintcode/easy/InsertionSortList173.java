/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * Created by Hughes on 2018/1/19 21:39.
 */
public class InsertionSortList173 implements Easy {

    /*
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            ListNode node = dummy;
            while (node.getNext() != null && node.getNext().getVal() < head.getVal()) {
                node = node.getNext();
            }
            ListNode temp = head.getNext();
            head.setNext(node.getNext());
            node.setNext(head);
            head = temp;
        }

        return dummy.getNext();
    }
}
