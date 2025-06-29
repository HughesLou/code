package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * X是一个好数当且仅当单独旋转每一个数位180度之后，能够得到一个合法的不同于X的数。
 * 每一个数位必须被旋转 - 我们不能选择不管它。
 * <p>
 * 如果每一个数位在旋转之后仍然是一个数位，那么这个数字是合法的。
 * 0,1和8旋转保持不变; 2和5旋转后互相变换; 6和9旋转后互相变换，其余数字旋转后不会变成任何数字所以是不合法的。
 * <p>
 * 现在给定一个正数 N，多少1 到 N 之间的数X是好的?
 *
 * @author HughesLou
 * Created on 2022-04-20
 */
public class RotatedDigits1028 implements Easy {
    /**
     * 遍历每一个数，由题意可知，6可以变成9，2可以变成5，是好数。1、8、0本身转变后没有改变，因此不考虑。
     * 如果存在3、4、7直接返回false，节约时间。
     *
     * @param n: a positive number
     * @return: how many numbers X from 1 to N are good
     */
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isValid(int n) {
        boolean valid = false;
        while (n > 0) {
            switch (n % 10) {
                case 3:
                case 4:
                case 7:
                    return false;
                case 2:
                case 5:
                case 6:
                case 9:
                    valid = true;
            }
            n /= 10;
        }
        return valid;
    }
}
