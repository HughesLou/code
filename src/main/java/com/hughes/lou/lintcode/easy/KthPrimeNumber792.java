package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class KthPrimeNumber792 implements Easy {
    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        byte[] prime = new byte[n + 1];
        for (int i = 2; i <= n; i++) {
            if ((prime[i] & 1) == 0) {
                for (int j = 2 * i; j <= n; j += i) {
                    prime[j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            if ((prime[i] & 1) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
