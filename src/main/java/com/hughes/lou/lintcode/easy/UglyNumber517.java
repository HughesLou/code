package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 检测一个整数是不是丑数。
 * <p>
 * 丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数因为他包含了质因子 7。
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class UglyNumber517 implements Easy {

    /**
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num >= 2 && num % 2 == 0) {
            num /= 2;
        }
        while (num >= 3 && num % 3 == 0) {
            num /= 3;
        }
        while (num >= 5 && num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
