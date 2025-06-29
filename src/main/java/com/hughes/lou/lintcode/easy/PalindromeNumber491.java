package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class PalindromeNumber491 implements Easy {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int r = sb.length() - 1;
        int l = 0;
        // 这里不需要=，=时表示中间就一个字符
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if(x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    public int reverse(int x) {
        int rst = 0;
        while(x != 0) {
            rst = rst * 10 + x % 10;
            x = x / 10;
        }
        return rst;
    }
}
