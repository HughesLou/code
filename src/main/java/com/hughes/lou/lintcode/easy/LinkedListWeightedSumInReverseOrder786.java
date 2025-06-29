package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ListNode;

/**
 * 链表的反向带权和
 * <p>
 * 给定一个链表，求出这个链表的带权和。链表结点的权值指的是该结点到链表尾节点的结点数
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class LinkedListWeightedSumInReverseOrder786 implements Easy {
    public int sum = 0;

    private int weightAdd(ListNode p) {
        if (p == null) {
            return 0;
        }
        int dist = 1 + weightAdd(p.next);
        sum += p.val * dist;
        return dist;
    }

    public int weightedSumReverse(ListNode head) {
        weightAdd(head);
        return sum;
    }

    /**
     * 利用前缀和
     */
    public int weightedSumReverse1(ListNode head) {
        int result = 0, sum = 0;
        while (head != null) {
            sum += head.val;
            result += sum;
            head = head.next;
        }
        return result;
    }
}