package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class FindPrime298 implements Naive {

    /**
     * @param n: an integer
     * @return: return all prime numbers within n.
     */
    public List<Integer> prime(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        FindPrime298 findPrime298 = new FindPrime298();
        System.out.println(findPrime298.prime(a));
    }
}