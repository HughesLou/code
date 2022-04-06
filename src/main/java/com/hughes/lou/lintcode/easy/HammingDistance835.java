package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 两个整数的Hamming距离是对应比特位不同的个数。
 * 给定两个整数x和y，计算两者的Hamming距离。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class HammingDistance835 implements Easy {
    /**
     * @param x: an integer
     * @param y: an integer
     * @return: return an integer, denote the Hamming Distance between two integers
     */
    public int hammingDistance(int x, int y) {
        int distance = 0;

        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                distance++;
            }
            x >>= 1;
            y >>= 1;
        }
        return distance;
    }

    public int hammingDistance1(int x, int y) {
        int distance = 0;

        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                distance++;
            }
            x /= 2;
            y /= 2;
        }
        return distance;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
