package com.hughes.lou.lintcode.navie;

import com.hughes.lou.level.Naive;
import com.hughes.lou.model.ListNode;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class CountLinkedListNodes466 implements Naive {

    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
