package com.hughes.lou.lintcode.navie;

import com.hughes.lou.level.Naive;
import com.hughes.lou.model.ListNode;

/**
 * 找链表的中点，并返回这个节点
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class MiddleOfLinkedList228 implements Naive {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}