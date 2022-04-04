package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class AddStrings655 implements Easy {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int m = num1.length(), n = num2.length(), i = m - 1, j = n - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int a, b;
            if (i >= 0) {
                a = num1.charAt(i--) - '0';
            } else {
                a = 0;
            }
            if (j >= 0) {
                b = num2.charAt(j--) - '0';
            } else {
                b = 0;
            }
            int sum = a + b + carry;
            res.insert(0, (char) (sum % 10 + '0'));
            carry = sum / 10;
        }
        return carry == 1 ? "1" + res : res.toString();
    }
}
