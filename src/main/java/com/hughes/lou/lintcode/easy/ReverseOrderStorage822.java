package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class ReverseOrderStorage822 implements Easy {
    List<Integer> res = new ArrayList<>();

    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> result = reverseStore(head.next);
        result.add(head.val);
        return result;
    }

    private List<Integer> store(ListNode p) {
        if (p == null) {
            return new ArrayList<>();
        }

        List<Integer> result = reverseStore(p.next);
        result.add(p.val);
        return result;
    }
}