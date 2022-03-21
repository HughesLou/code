package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-20
 */
public class InsertFive188 implements Easy {

    /**
     * 如果a是正数，我们要想尽办法让数字大，所以我们把5插入第一次遇见的比五小的数前面。
     * 如果a是负数，我们要想尽办法让去掉负号后的数字小，所以我们把5插入到第一次遇见的比五大的数前面。
     *
     * @param a: A number
     * @return: Returns the maximum number after insertion
     */
    public int InsertFive(int a) {
        String num = String.valueOf(a);
        int i = 0;
        if (a >= 0) {
            while (i < num.length() && num.charAt(i) > '5') {
                i++;
            }
        }
        else {
            i = 1;
            while (i < num.length() && num.charAt(i) <= '5') {
                i++;
            }
        }
        return Integer.parseInt(num.substring(0, i) + '5' + num.substring(i));
    }
}
