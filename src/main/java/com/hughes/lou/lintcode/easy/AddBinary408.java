package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class AddBinary408 implements Easy {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            ans.insert(0, (sum % 2));
            carry = sum / 2;
        }
        if (carry != 0) {
            ans.insert(0, carry);
        }
        return ans.toString();
    }
}
