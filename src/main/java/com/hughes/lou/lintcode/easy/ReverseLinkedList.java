package com.hughes.lou.lintcode.easy;


import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * Created by Hughes on 2016/8/14.
 */
public class ReverseLinkedList implements Easy {

    public ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode reversedHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    public ListNode reverse2(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        head = pre;
        return head;
    }

    /**
     * @param head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode q = null;
        ListNode p = head;
        for (int i = 1; i < m; i++) {
            q = p;
            p = p.next;
        }
        ListNode end = p;
        ListNode pPre = p;
        p = p.next;
        for (int i = m + 1; i <= n; i++) {
            ListNode pNext = p.next;

            p.next = pPre;
            pPre = p;
            p = pNext;
        }
        end.next = p;
        if (q != null) {
            q.next = pPre;
        } else {
            head = pPre;
        }
        return head;
    }
}
