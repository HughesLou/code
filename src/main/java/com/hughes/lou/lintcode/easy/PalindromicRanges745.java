/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * Created by Hughes on 2018/1/21 00:07.
 */
public class PalindromicRanges745 implements Easy {

    /**
     * @param L: A positive integer
     * @param R: A positive integer
     * @return: the number of interesting subranges of [L, R]
     */
    public static int PalindromicRanges(int L, int R) {
        if (L > R) {
            return 0;
        }
        if (L == R) {
            return isPalindrom(R) ? 0 : 1;
        }
        int[] dp = new int[R - L + 2];
        dp[0] = 0;
        for (int i = 0; i <= R - L; i++) {
            dp[i + 1] = dp[i];
            if (isPalindrom(i + L)) {
                dp[i + 1]++;
            }
        }
        int total = 0;
        for (int i = 1; i <= R - L + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int count = dp[i] - dp[j];
                //按照题目中第三个例子，range里面不存在palindrom也算valid range, means count could equal to 0
                if (count % 2 == 0) {
                    total++;
                }
            }
        }
        return total;
    }

    //判断是否为回文
    private static boolean isPalindrom(int x) {
        if (x / 10 == 0) {
            return true;
        }
        String s = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder().append(s);
        if (!stringBuilder.reverse().toString().equals(s)) {
            return false;
        }
        return true;
        //        int left = 0;
        //        int right = s.length() - 1;
        //        while (left < right) {
        //            if (s.charAt(left) != s.charAt(right)) {
        //                return false;
        //            }
        //            left++;
        //            right--;
        //        }
        //        return true;
    }

    public static void main(String[] args) {
        int result = PalindromicRanges(1, 1);
        System.out.println(result);
    }
}
