package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hughes.lou.level.Easy;
import com.hughes.lou.utils.ObjectMapperUtils;

/**
 * 将一个整数分解为若干质因数之乘积。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class PrimeFactorization235 implements Easy {

    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        List<Integer> factors = new ArrayList<>();
        // 当i比较大时可能会引起异常
        for (int i = 2; i <= num / i; i++) {
            while (num % i == 0) {
                num = num / i;
                factors.add(i);
            }
        }
        // 若最后剩余数不为1，则为最后一个质因数
        if (num != 1) {
            factors.add(num);
        }
        return factors;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        PrimeFactorization235 primeFactorization235 = new PrimeFactorization235();
        System.out.println(ObjectMapperUtils.toJSON(primeFactorization235.primeFactorization(a)));
    }
}
