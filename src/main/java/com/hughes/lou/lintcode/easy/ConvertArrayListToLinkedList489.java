package com.hughes.lou.lintcode.easy;

import java.util.List;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class ConvertArrayListToLinkedList489 implements Easy {
    /**
     * @param nums: an integer array
     * @return: the first node of linked list
     */
    public ListNode toLinkedList(List<Integer> nums) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (Integer num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}
