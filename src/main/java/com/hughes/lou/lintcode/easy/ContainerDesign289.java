package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 你的任务是设计一个数据结构来存放一系列的数字，并且支持以下三种操作：
 * <p>
 * add(element)
 * 在数据结构中增加一个整数 element。若 element 已经存在于数据结构中，本次操作无效。
 * remove(element)
 * 在数据结构中删除一个整数 element。若 element 不存在于数据结构中，本次操作无效。
 * getSum()
 * 对数据结构中的整数求和。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class ContainerDesign289 implements Easy {
    private List<Integer> elements = new ArrayList<>();
    private int sum = 0;

    /**
     * @param element: Add element into this container.
     * @return: nothing
     */
    public void add(int element) {
        int index = elements.indexOf(element);
        if (index < 0) {
            elements.add(element);
            sum += element;
        }
    }

    /**
     * @param element: Remove element into this container.
     * @return: nothing
     */
    public void remove(int element) {
        int index = elements.indexOf(element);
        if (index >= 0) {
            elements.remove(index);
            sum -= element;
        }
    }

    /**
     * @return: Sum of integers.
     */
    public int getSum() {
        return sum;
    }
}
