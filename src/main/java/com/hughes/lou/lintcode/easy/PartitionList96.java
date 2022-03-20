/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。你应该保留两部分内链表节点原有的相对顺序。
 * <p>
 * Created by hughes on 2017/12/17 23:23.
 */
public class PartitionList96 implements Easy {

    /*
     * 双指针方法，用两个指针将两个部分分别串起来。最后在将两个部分拼接起来。
     * left指针用来串起来所有小于x的结点， right指针用来串起来所有大于等于x的结点。
     * 得到两个链表，一个是小于x的，一个是大于等于x的，做一个拼接即可。
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return null;
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
