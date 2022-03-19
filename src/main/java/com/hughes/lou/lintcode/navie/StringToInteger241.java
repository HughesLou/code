package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * 给一个字符串, 转换为整数。你可以假设这个字符串是一个有效整数的字符串形式， 且范围在32位整数之间 (-2^31 ~ 2^31 - 1)。
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class StringToInteger241 implements Naive {

    /**
     * @param target: A string
     * @return: An integer
     */
    public int stringToInteger(String target) {
        int result = 0;
        boolean positive = true;
        int position = 0;
        if (target.charAt(0) == '-') {
            positive = false;
            position = 1;
        } else if (target.charAt(0) == '+') {
            position = 1;
        }

        for (int i = position; i < target.length(); i++) {
            result = result * 10 + target.charAt(i) - '0';
        }
        return positive ? result : -result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();

        StringToInteger241 stringToInteger241 = new StringToInteger241();
        System.out.println(stringToInteger241.stringToInteger(a));
    }
}
