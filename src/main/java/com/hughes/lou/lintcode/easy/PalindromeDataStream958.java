package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 一个数据流进来，每次一个小写字母，当前数据流的排列是否能组成回文串。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class PalindromeDataStream958 implements Easy {

    /**
     * 当且仅当出现次数为奇数的字符个数为0或1时可以构成回文串
     *
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        int[] ans = new int[s.length()];
        int[] alphabet = new int[256];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alphabet[c] % 2 == 1) {
                cnt--;
                alphabet[c]++;
            } else {
                cnt++;
                alphabet[c]++;
            }
            if (cnt > 1) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
