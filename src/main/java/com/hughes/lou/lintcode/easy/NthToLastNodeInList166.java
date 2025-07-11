package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * 找到单链表的倒数第n个节点，保证链表中节点的最少数量为n。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class NthToLastNodeInList166 implements Easy {

    /**
     * 两个指针，先让快指针走n步， 然后一起走，快指针到头的时候，慢指针就是倒数第n个
     *
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list.
     */
    public ListNode nthToLast(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        for (int j = 0; j < n - 1; ++j) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
