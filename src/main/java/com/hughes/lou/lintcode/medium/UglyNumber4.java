package com.hughes.lou.lintcode.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.hughes.lou.lintcode.level.Medium;

/**
 * 找出只含素因子2，3，5 的第 n 小的数。
 * <p>
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 *
 * @author HughesLou
 * Created on 2021-02-26
 */
public class UglyNumber4 implements Medium {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // 借助优先队列(二叉小顶堆实现)
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);

        Set<Long> exist = new HashSet();
        exist.add(1L);

        int[] factors = new int[] {2, 3, 5};

        long currUgly = 1, newUgly;

        for (int i = 0; i < n; ++i) {
            // 每次弹出当前最小丑数
            currUgly = heap.poll();
            // 生成新的丑数
            for (int f : factors) {
                newUgly = currUgly * f;
                if (!exist.contains(newUgly)) {
                    exist.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return (int) currUgly;
    }
}
