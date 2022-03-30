package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 假如你有一堆的盘子。如果你堆得太高的话，就可能会垮掉。
 * 所以，在真实的生活中，如果盘子叠到一定高度，你会重新开始堆新的一堆盘子。
 * <p>
 * 实现这样的一个数据结构，我们称之为栈集，来模拟这个过程。
 * 这个栈集包含若干个栈（可以理解为若干堆的盘子），如果一个栈满了，就需要新建一个栈来装新加入的项。
 * 你需要实现栈集的两个方法，push(item) 和 pop()，让这个栈集对外表现得就像是一个栈在进行操作一样。
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class SetOfStacks490 implements Easy {
    List<Stack<Integer>> stacks = new ArrayList<>();
    public int capacity;

    // @param capacity an inetger, capacity of sub stack
    public SetOfStacks490(int capacity) {
        // do initialization if necessary
        this.capacity = capacity;
    }

    public Stack<Integer> getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    // @param v an integer
    public void push(int v) {
        Stack<Integer> last = getLastStack();
        if (last != null && last.capacity() < capacity) { // add to last stack
            last.push(v);
        } else { // must create new stack
            Stack<Integer> stack = new Stack<>();
            stack.push(v);
            stacks.add(stack);
        }
    }

    // @return an integer
    public int pop() {
        Stack<Integer> last = getLastStack();
        int v = last.pop();
        if (last.capacity() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }
}