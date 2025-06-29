package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class GuessNumberHigherOrLower662 implements Easy {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = guessNumber(mid);
            if (res == 0) {
                return mid;
            }

            if (res == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
