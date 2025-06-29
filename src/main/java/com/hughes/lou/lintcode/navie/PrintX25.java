package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hughes.lou.level.Naive;
import com.hughes.lou.utils.ObjectMapperUtils;

/**
 * 输入一个正整数N， 你需要按样例的方式返回一个字符串列表。
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class PrintX25 implements Naive {

    /**
     * @param n: An integer.
     * @return: A string list.
     */
    public List<String> printX(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                tmp.append((i == j || j == n - 1 - i) ? "X" : " ");
            }
            list.add(tmp.toString());
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        PrintX25 printX25 = new PrintX25();
        System.out.println(ObjectMapperUtils.toJSON(printX25.printX(a)));
    }
}