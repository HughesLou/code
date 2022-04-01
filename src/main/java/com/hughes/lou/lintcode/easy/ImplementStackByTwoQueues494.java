package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class ImplementStackByTwoQueues494 implements Easy {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        queue1.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // 如果queue1为空，代表栈顶在queue2，交换
        if (queue1.isEmpty()) {
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        // 将queue1前n-1个放入queue2，弹出最后的元素
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        queue1.poll();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // 如果queue1为空，代表栈顶在queue2，交换
        if (queue1.isEmpty()) {
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        // 将queue1前n-1个放入queue2，获得最后的元素
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        return queue1.peek();
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
