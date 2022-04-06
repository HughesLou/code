package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一个单词序列，检查它是否构成一个有效单词方阵。
 * 一个有效的单词方阵应满足以下条件：对于满足0≤k<max(numRows numColumns)的k，第k行和第k列对应的字符串应该相同,。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class ValidWordSquare888 implements Easy {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        if (words.length != words[0].length()) {
            return false;
        }
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                if (j >= words.length || i >= words[j].length() || words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
