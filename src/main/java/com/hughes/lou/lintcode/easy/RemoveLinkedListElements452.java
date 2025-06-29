package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class RemoveLinkedListElements452 implements Easy {

    /**
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = pre;
                // 如果只删除一个，这里直接break
            }
            pre = head;
            head = head.next;
        }

        return dummy.next;
    }
}
