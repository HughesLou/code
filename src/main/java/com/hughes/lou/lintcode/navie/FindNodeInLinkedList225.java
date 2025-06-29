package com.hughes.lou.lintcode.navie;

import com.hughes.lou.level.Naive;
import com.hughes.lou.model.ListNode;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class FindNodeInLinkedList225 implements Naive {
    /**
     * @param head: the head of linked list.
     * @param val: An integer.
     * @return: a linked node or null.
     */
    public ListNode findNode(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                return head;
            } else {
                head = head.next;
            }
        }
        return null;
    }
}