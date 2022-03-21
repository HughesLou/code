package com.hughes.lou.lintcode.model;

import java.util.Stack;

/**
 * @author HughesLou
 * Created on 2022-03-20
 */
public class Tower {
    private Stack<Integer> disks;

    /*
     * @param i: An integer from 0 to 2
     */
    public Tower(int i) {
        disks = new Stack<>();
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(Tower t) {
        t.add(disks.pop());
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination); //// 以目标杆为中介，从起始杆将1至n-1号盘移至中间杆
            moveTopTo(destination); //将起始杆里的第n号盘移动到目标杆
            buffer.moveDisks(n - 1, destination, this); //以起始杆为中介，从中间杆将1至n-1号盘移至目标杆
        }
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        return disks;
    }
}