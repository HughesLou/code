package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * 将一个字符串中的小写字母转换为大写字母。不是字母的字符不需要做改变。
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class LowercaseToUppercase146 implements Naive {

    /**
     * @param letters: A string
     * @return: A string
     */
    public String lowercaseToUppercase(String letters) {
        char[] temp = letters.toCharArray();
        for(int i = 0; i < temp.length; i++){
            if('a'<= temp[i] && temp[i] <= 'z'){
                temp[i] -= 32;
            }
        }
        return String.valueOf(temp);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();

        LowercaseToUppercase146 lowercaseToUppercase146 = new LowercaseToUppercase146();
        System.out.println(lowercaseToUppercase146.lowercaseToUppercase(a));
    }
}