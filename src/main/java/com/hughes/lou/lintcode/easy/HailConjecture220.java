package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 数学家们曾提出一个著名的猜想——冰雹猜想。
 * 对于任意一个自然数N，如果N是偶数，就把它变成N / 2；
 * 如果N是奇数，就把它变成 3 * N+1。
 * 按照这个法则运算下去，最终必然得1。
 * 试问，该数通过几轮变换，会变成1呢？
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class HailConjecture220 implements Easy {

    /**
     * @param num: an integer
     * @return: an integer
     */
    public int getAnswer(int num) {
        int count = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = 3 * num + 1;
            }
            count++;
        }
        return count;
    }
}
