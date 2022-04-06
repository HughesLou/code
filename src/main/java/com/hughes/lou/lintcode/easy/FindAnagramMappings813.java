package com.hughes.lou.lintcode.easy;

import java.util.HashMap;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给出了两个A和B的列表，从A映射到B，B是由A的一种回文构词法构成通过随机化A中元素的顺序来实现的。
 * 我们想要找到一个指数映射P，从A到B，映射P[i] = j表示A出现在B中的第i个元素。
 * 这些列表A和B可能包含重复。如果有多个答案，输出任何一个。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class FindAnagramMappings813 implements Easy {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        int l = A.length;
        int[] result = new int[l];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < l; i++) {
            result[i] = map.get(A[i]);
        }

        return result;
    }
}
