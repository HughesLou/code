package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * 给出两个链表形式表示的数字,写一个函数得到这两个链表相乘乘积
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class MultiplyTwoNumbers756 implements Easy {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the product list of l1 and l2
     */
    public long multiplyLists(ListNode l1, ListNode l2) {
        long p1 = 0;
        while (l1 != null) {
            p1 = p1 * 10 + l1.val;
            l1 = l1.next;
        }

        long p2 = 0;
        while (l2 != null) {
            p2 = p2 * 10 + l2.val;
            l2 = l2.next;
        }

        return p1 * p2;
    }
}
