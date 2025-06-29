package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，每个元素只留下一个。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class RemoveDuplicatesFromSortedList112 implements Easy {

    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
