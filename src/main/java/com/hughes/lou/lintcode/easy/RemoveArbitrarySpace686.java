package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class RemoveArbitrarySpace686 implements Easy {
    /**
     * @param s: the original string
     * @return: the string without arbitrary spaces
     */
    public String removeExtra(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                boolean isntBegin = i != 0;
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                if (isntBegin && i < s.length()) {
                    ans.append(' ');
                }
            }

            while (i < s.length() && s.charAt(i) != ' ') {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}
