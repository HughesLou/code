package com.hughes.lou.lintcode.easy;

import java.util.Arrays;
import java.util.Scanner;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-19
 */
public class RotateString8 implements Easy {
    /**
     * @param s: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] s, int offset) {
        if (s == null || s.length == 0)
            return;

        offset = offset % s.length;
        reverse(s, 0, s.length - offset - 1);
        System.out.println(Arrays.toString(s));
        reverse(s, s.length - offset, s.length - 1);
        System.out.println(Arrays.toString(s));
        reverse(s, 0, s.length - 1);
        System.out.println(Arrays.toString(s));
    }

    private void reverse(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.nextLine().toCharArray();
        int offset = Integer.parseInt(scanner.nextLine());

        RotateString8 rotateString8 = new RotateString8();
        rotateString8.rotateString(s, offset);
        System.out.println(Arrays.toString(s));
    }
}
