package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class LowercaseToUppercase145 implements Naive {

    /**
     * @param character: a character
     * @return: a character
     */
    public char lowercaseToUppercase(char character) {
        //        return (char)(character - 'a' + 'A');
        return (char) (character - 32);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);

        LowercaseToUppercase145 lowercaseToUppercase145 = new LowercaseToUppercase145();
        System.out.println(lowercaseToUppercase145.lowercaseToUppercase(a));
    }
}