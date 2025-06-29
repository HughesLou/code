package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 数字变形
 * <p>
 * 现在题目给出一个整数A。
 * 整数B是A的变形，由整数A的位数交替形成。
 * 依次为A的右数第一位数，左数第一位数，右数第二位数.....以此类推，得到整数B。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class DigitalDistortion310 implements Easy {

    /**
     * @param A: the integer discrible in problem @return: the integer after distortion
     */
    public String Distortion(String A) {
        int length = A.length();
        StringBuilder B = new StringBuilder().append(A.charAt(length - 1));
        int i = 0;
        int j = length - 2;
        while (i <= j) {
            B.append(A.charAt(i));
            if (i < j) {
                B.append(A.charAt(j));
            }
            i++;
            j--;
        }
        return B.toString();
    }
}
