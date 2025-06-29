package com.hughes.lou.lintcode.easy;

import java.util.HashSet;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * 设计一种方法，从无序链表中删除重复项。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class RemoveDuplicatesFromUnsortedList217 implements Easy {

    /**
     * @param head: The first node of linked list.
     * @return: Head node.
     */
    public ListNode removeDuplicates(ListNode head) {
        HashSet<Integer> hash = new HashSet<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            int val = head.next.val;
            if (hash.contains(val)) {
                head.next = head.next.next;
            } else {
                hash.add(val);
                head = head.next;
            }
        }

        return dummy.next;
    }
}
