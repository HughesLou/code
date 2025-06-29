package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 你的任务是设计一个数据结构来存放一系列的数字，并且支持以下两种操作：
 * <p>
 * add(element)
 * 在数据结构中增加一个整数 element。
 * getSum()
 * 对数据结构中的整数求和。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class ContainerDesign288 implements Easy {
    private int sum = 0;

    /**
     * @param element: Add element into this container.
     * @return: nothing
     */
    public void add(int element) {
        sum += element;
    }

    /**
     * @return: Sum of integers.
     */
    public int getSum() {
        return sum;
    }
}
