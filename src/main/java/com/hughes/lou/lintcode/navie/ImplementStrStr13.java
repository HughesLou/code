package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.level.Naive;

/**
 * @author HughesLou
 * <p>
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * <p>
 * Created on 2022-03-17
 */
public class ImplementStrStr13 implements Naive {

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int targetLength = target.length();
        for (int i = 0; i < source.length() - targetLength + 1; i++) {
            int j = 0;
            for (; j < targetLength; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == targetLength) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String target = scanner.nextLine();

        ImplementStrStr13 implementStrStr = new ImplementStrStr13();
        int result = implementStrStr.strStr(source, target);
        System.out.println(result);
    }
}
