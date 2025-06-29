package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class IsAlphaNumber23 implements Naive {

    /**
     * @param c: A character.
     * @return: The character is alphanumeric or not.
     */
    public boolean isAlphanumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        //        return ((int) c >= 48 && (int) c <= 57)
        //        || ((int) c >= 65 && (int) c <= 90)
        //        || ((int) c >= 97 && (int) c <= 122);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        IsAlphaNumber23 isAlphaNumber23 = new IsAlphaNumber23();
        System.out.println(isAlphaNumber23.isAlphanumeric(input.charAt(0)));
    }
}