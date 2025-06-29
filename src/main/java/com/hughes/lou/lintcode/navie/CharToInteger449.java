package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class CharToInteger449 implements Naive {

    /**
     * @param character: a character
     * @return: An integer
     */
    public int charToInteger(char character) {
        return character;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);

        CharToInteger449 charToInteger449 = new CharToInteger449();
        System.out.println(charToInteger449.charToInteger(a));
    }
}
