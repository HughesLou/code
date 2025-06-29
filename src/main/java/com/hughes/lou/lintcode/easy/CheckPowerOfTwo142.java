package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-19
 */
public class CheckPowerOfTwo142 implements Easy {

    /**
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
