package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class RemoveNthNodeFromEndOfList174 implements Easy {

    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
