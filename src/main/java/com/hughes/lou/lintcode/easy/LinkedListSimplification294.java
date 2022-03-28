package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * 简化链表
 * <p>
 * 给出一个字符链表，对其进行简化。
 * 简化的过程为，保留链表的头尾节点，用数字代替掉中间的部分。
 * 数字也要用字符链表表示。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class LinkedListSimplification294 implements Easy {

    /**
     * 输入的字符链表用一个整型链表表示，链表的每个节点的值都是其对应的ASCII码。
     * 输入的字符链表的节点数为 n, 3 ≤ n <= 10^4
     *
     * @param head: the linked list to be simplify.
     * @return: return the linked list after simplifiction.
     */
    public ListNode simplify(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        ListNode q = head;
        for (char c : String.valueOf(count - 1).toCharArray()) {
            head.next = new ListNode(c);
            head = head.next;
        }
        head.next = p;
        return q;
    }
}
