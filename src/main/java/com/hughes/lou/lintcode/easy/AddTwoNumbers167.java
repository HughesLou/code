/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
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
            int sum = l1.getVal() + l2.getVal() + carry;
            carry = sum / 10;
            current.setNext(new ListNode(sum % 10));
            current = current.getNext();
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        while (null != l1) {
            int sum = l1.getVal() + carry;
            carry = sum / 10;
            current.setNext(new ListNode(sum % 10));
            current = current.getNext();
            l1 = l1.getNext();
        }
        while (null != l2) {
            int sum = l2.getVal() + carry;
            carry = sum / 10;
            current.setNext(new ListNode(sum % 10));
            current = current.getNext();
            l2 = l2.getNext();
        }
        if (0 != carry) {
            current.setNext(new ListNode(carry));
        }
        return result.getNext();
    }
}
