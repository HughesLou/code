package com.hughes.lou.lintcode.easy;

import java.util.HashSet;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 写一个算法来判断一个数是不是"快乐数"。
 * <p>
 * 一个数是不是快乐是这么定义的：
 * 对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。
 * 如果可以变为1，那么这个数就是快乐数。
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class HappyNumber488 implements Easy {

    /**
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // 判断是否陷入循环
        HashSet<Integer> hash = new HashSet<>();
        while (n != 1) {
            if (hash.contains(n)) {
                return false;
            }
            hash.add(n);
            n = getNextHappy(n);
        }
        return true;
    }

    private int getNextHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
