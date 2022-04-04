package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给出一串整数流和窗口大小，计算滑动窗口中所有整数的平均值。
 *
 * @author HughesLou
 * Created on 2022-04-02
 */
public class MovingAverageFromDataStream642 implements Easy {
    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    /*
     * @param size: An integer
     */
    public MovingAverageFromDataStream642(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        sum += val;
        if (queue.size() == size) {
            sum = sum - queue.poll();
        }
        queue.offer(val);
        return sum / queue.size();
    }
}
