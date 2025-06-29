package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class CountAndSay420 implements Easy {

    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        String result = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] oldChars = result.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(count).append(oldChars[i]);
            }
            result = sb.toString();
        }

        return result;
    }
}
