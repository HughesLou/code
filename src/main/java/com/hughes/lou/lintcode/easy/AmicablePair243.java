package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 一对相亲数是指两个整数各自的所有有效因子（除了自己以外的因子）之和等于另外一个数。比如 (220, 284) 就是一对相亲数。因为：
 * <p>
 * 220的所有因子：1+2+4+5+10+11+20+22+44+55+110 = 284
 * 284的所有因子：1+2+4+71+142 = 220
 * 给出整数 k，求 1~k 之间的所有相亲数对。
 *
 * @author HughesLou
 * Created on 2022-03-21
 */
public class AmicablePair243 implements Easy {

    /**
     * @param k: An integer
     * @return: all amicable pairs
     * we will sort your return value in output
     */
    public List<List<Integer>> amicablePair(int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 2; i <= k; ++i) {
            int amicable = factorSum(i);
            // 确定一个方向，i的相亲数需要比i大
            if (amicable <= i || amicable > k) {
                continue;
            }
            if (factorSum(amicable) == i) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(amicable);
                result.add(pair);
            }
        }
        return result;
    }

    /**
     * @param k an integer
     * @return all amicable pairs
     */
    public int factorSum(int k) {
        int sum = 1, i;
        for (i = 2; i * i < k; ++i) {
            if (k % i == 0) {
                sum += i + k / i;
            }
        }
        if (i * i == k) {
            sum += i;
        }
        return sum;
    }
}
