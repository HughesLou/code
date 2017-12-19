/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

package com.hughes.lintCode.easy;

import com.hughes.lintCode.model.ListNode;

/**
 * Created by luzhiwei01 on 2017/12/17 23:23.
 */
public class PartitionList96 {

    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (null == head) {
            return head;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftTemp = left, rightTemp = right;
        while (null != head) {
            if (head.val < x) {
                leftTemp.next = head;
                leftTemp = leftTemp.next;
            } else {
                rightTemp.next = head;
                rightTemp = rightTemp.next;
            }
            head = head.next;
        }
        rightTemp.next = null;
        leftTemp.next = right.next;
        return left.next;
    }
}
