package com.hughes.lou.lintcode.hard;

import com.hughes.lou.lintcode.level.Hard;

/**
 * 当以下条件都满足时，一个密码被视为是强密码：
 * <p>
 * 至少包含6个字符，但不超过20个字符。
 * 至少包含一个小写字母，一个大写字母，和一个数字。
 * 不能包含三个连续的重复字符（"...aaa..."是弱密码，但"...aa...a..."是强密码，假设它们的其他条件都满足了）。
 * <p>
 * 写一个函数strongPasswordChecker(s)，它将一个字符串s作为输入，
 * 并且返回将其转换成强密码需要的最少改变次数。如果s已经是一个强密码了，返回0。
 * <p>
 * 插入、删除或者替换任意一个字符都视为一次改变。
 *
 * @author hugheslou
 * Created on 2018-12-26.
 */
public class StrongPasswordChecker implements Hard {

    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 20;

    public static void main(String[] args) {
        StrongPasswordChecker checker = new StrongPasswordChecker();
        System.out.println(checker.check("1xABABABABABAAAABBABA"));
    }

    public int check(String input) {
        int changes = 0;
        int length = input.length();
        char[] chars = input.toCharArray();
        int missDigit = 1;
        int missLowerCase = 1;
        int missUpperCase = 1;
        // 用于统计当前位置开始的连续相同字符的个数
        int[] characterCount = new int[length];
        for (int i = 0; i < length; ) {
            if (missLowerCase > 0 && chars[i] >= 'a' && chars[i] <= 'z') {
                missLowerCase = 0;
            }
            if (missUpperCase > 0 && chars[i] >= 'A' && chars[i] <= 'Z') {
                missUpperCase = 0;
            }
            if (missDigit > 0 && chars[i] >= '0' && chars[i] <= '9') {
                missDigit = 0;
            }
            int j = i;
            while (i < length && chars[i] == chars[j]) {
                ++i;
            }
            characterCount[j] = i - j;
        }
        int miss = missDigit + missLowerCase + missUpperCase;

        if (length < MIN_LENGTH) {
            // 添加新的字符
            changes += Math.max(MIN_LENGTH - length, miss);
        } else {
            int over = Math.max(length - MAX_LENGTH, 0), deleteRepeat = 0;
            changes += over;
            // 将连续字符串删除到3m+2个，后面直接替换m个字符即可达到要求
            for (int k = 1; k < 3; ++k) {
                for (int i = 0; i < length && over > 0; ++i) {
                    if (characterCount[i] < 3 || characterCount[i] % 3 != (k - 1)) {
                        continue;
                    }
                    characterCount[i] -= k;
                    over -= k;
                }
            }
            for (int i = 0; i < length; ++i) {
                if (characterCount[i] >= 3 && over > 0) {
                    int needDelete = characterCount[i] - 2;
                    characterCount[i] -= over;
                    over -= needDelete;
                }
                if (characterCount[i] >= 3) {
                    deleteRepeat += characterCount[i] / 3;
                }
            }
            changes += Math.max(miss, deleteRepeat);
        }

        return changes;
    }
}