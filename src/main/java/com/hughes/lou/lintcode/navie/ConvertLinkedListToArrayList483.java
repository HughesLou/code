package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Naive;
import com.hughes.lou.lintcode.model.ListNode;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class ConvertLinkedListToArrayList483 implements Naive {
    /**
     * @param head: the head of linked list.
     * @return: An integer list
     */
    public List<Integer> toArrayList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.getVal());
            head = head.getNext();
        }
        return result;
    }
}