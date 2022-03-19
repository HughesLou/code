package com.hughes.lou.lintcode.navie;

import com.hughes.lou.lintcode.level.Naive;
import com.hughes.lou.lintcode.model.ListNode;

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
            if (head.getVal() == val) {
                return head;
            } else {
                head = head.getNext();
            }
        }
        return null;
    }
}