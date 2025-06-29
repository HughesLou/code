/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。
 * 数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 * <p>
 * Created by hughes on 2017/12/24 23:03.
 */
public class AddTwoNumbers167 implements Easy {
    /*
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (null != l1 && null != l2) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (null != l1) {
            int sum = l1.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
        }
        while (null != l2) {
            int sum = l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l2 = l2.next;
        }
        if (0 != carry) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }
}
