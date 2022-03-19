package com.hughes.lou.lintcode.navie;

import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * 给出两个整数 a , b ,以及一个操作符 opeator +, -, *, / 返回结果 a<operator>b
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class SimpleCalculator478 implements Naive {

    /**
     * @param a: An integer
     * @param op: A character, +, -, *, /.
     * @param b: An integer
     * @return: The result
     */
    public int calculate(int a, char op, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        char op = scanner.nextLine().charAt(0);
        int b = Integer.parseInt(scanner.nextLine());

        SimpleCalculator478 simpleCalculator478 = new SimpleCalculator478();
        System.out.println(simpleCalculator478.calculate(a, op, b));
    }
}
