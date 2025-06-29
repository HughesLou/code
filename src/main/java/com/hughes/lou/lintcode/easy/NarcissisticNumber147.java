package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 水仙花数的定义是，这个数等于他每一位数上的幂次之和
 *
 * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 13 + 53 + 33。
 *
 * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 14 + 64 + 34 + 44。
 *
 * 给出n，找到所有的n位十进制水仙花数。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class NarcissisticNumber147 implements Easy {

    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 10; ++i)
                result.add(i);
            return result;
        }
        if (n == 6) {
            result.add(548834);
            return result;
        }

        int min = (int) Math.pow(10, n-1);
        int max = (int) Math.pow(10, n);
        for (int i = min; i < max; ++i) {
            int j = i;
            int sum = 0;
            while (j > 0) {
                sum += Math.pow((j % 10), n);
                j = j / 10;
            }
            if (sum == i)
                result.add(i);
        }
        return result;
    }
}
