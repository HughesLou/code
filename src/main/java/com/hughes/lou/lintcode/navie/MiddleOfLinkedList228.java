package com.hughes.lou.lintcode.navie;

import com.hughes.lou.lintcode.level.Naive;
import com.hughes.lou.lintcode.model.ListNode;

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
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode slow = head, fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}