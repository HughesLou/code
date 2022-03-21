package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。
 * <p>
 * 元素的顺序可以改变，并且对新的数组不会有影响。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class RemoveElement172 implements Easy {

    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int i = 0;
        int length = A.length;
        while (i < length) {
            if (A[i] == elem) {
                A[i] = A[--length];
            } else {
                i++;
            }
        }
        return length;
    }

    public int removeElement0(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[index] = A[i];
                index++;
            }
        }

        return index;
    }
}
