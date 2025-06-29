package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 多字符串查找
 * <p>
 * 给出一个源字符串sourceString和一个目标字符串数组targetStrings，判断目标字符串数组中的每一个字符串是否是源字符串的子串
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class MultiStringSearch255 implements Easy {

    /**
     * @param sourceString: a string
     * @param targetStrings: a string array
     * @return: Returns a bool array indicating whether each string in targetStrings is a substring of the sourceString
     */
    public boolean[] whetherStringsAreSubstrings(String sourceString, String[] targetStrings) {
        // null checker
        if (sourceString == null || targetStrings == null) {
            return null;
        }

        boolean[] rst = new boolean[targetStrings.length];
        int idx = 0;
        for (String tmp : targetStrings) {
            rst[idx++] = contains(sourceString, tmp);
        }
        return rst;
    }

    private boolean contains(String source, String target) {
        boolean rst = true;

        int targetIdx = 0;
        for (int i = 0; i < source.length(); i++) {
            if (targetIdx == target.length()) {
                break;
            }
            if (source.charAt(i) == target.charAt(targetIdx)) {
                targetIdx++;
            } else {
                targetIdx = 0;
                if (source.charAt(i) == target.charAt(targetIdx)) {
                    targetIdx++;
                }
            }
        }

        if (targetIdx != target.length()) {
            return false;
        }

        return rst;
    }
}
