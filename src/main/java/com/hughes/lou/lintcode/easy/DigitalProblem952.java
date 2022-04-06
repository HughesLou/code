package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给一个转换规则来转换数字n：
 * n是奇数，n = 3n + 1
 * n是偶数，n = n / 2
 * 经过若干次转换后，n会变成1。
 * <p>
 * 现在给一个n，输出它转换到1需要的次数。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class DigitalProblem952 implements Easy {
    /**
     * @param n: the number n
     * @return: the times n convert to 1
     */
    public int digitConvert(int n) {
        int cnt = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            cnt++;
        }
        return cnt;
    }
}