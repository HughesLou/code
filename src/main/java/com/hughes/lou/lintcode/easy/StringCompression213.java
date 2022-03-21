package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 设计一种方法，通过给重复字符计数来进行基本的字符串压缩。
 * <p>
 * 例如，字符串 aabcccccaaa 可压缩为 a2b1c5a3 。
 * 而如果压缩后的字符数不小于原始的字符数，则返回原始的字符串。
 * <p>
 * 可以假设字符串仅包括 a-z 的大/小写字母。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class StringCompression213 implements Easy {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        if (originalString == null || originalString.length() == 0) {
            return originalString;
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < originalString.length()) {
            if (originalString.charAt(i) != originalString.charAt(j)) {
                sb.append(originalString.charAt(i));
                sb.append(j - i);
                // i每次指向下一个新的字符
                i = j;
            }
            j++;
        }
        // j走完str字符串，把剩余需要压缩的放到StringBuilder里。
        sb.append(originalString.charAt(i));
        sb.append(j - i);

        if (sb.length() >= originalString.length()) {
            return originalString;
        }
        return sb.toString();
    }
}
