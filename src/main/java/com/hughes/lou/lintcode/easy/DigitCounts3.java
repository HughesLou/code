package com.hughes.lou.lintcode.easy;

import java.util.Scanner;

import com.hughes.lou.level.Easy;

/**
 * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 *
 * @author HughesLou
 * Created on 2021-02-26
 */
public class DigitCounts3 implements Easy {

    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
        }
        return cnt;
    }

    public int singleCount(int i, int k) {
        if (i == 0 && k == 0) {
            return 1;
        }
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) {
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        DigitCounts3 digitCounts3 = new DigitCounts3();
        System.out.println(digitCounts3.digitCounts(k, n));
    }
}