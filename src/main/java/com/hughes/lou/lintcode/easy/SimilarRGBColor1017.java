package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 在本题中，每个大写字母代表从“0”到“f”的一些十六进制数字。
 * <p>
 * 红绿蓝三元色#AABBCC可以简写为#ABC。 例如，#15c是颜色#1155cc的简写。
 * <p>
 * 现在，定义两种颜色#ABCDEF和#UVWXYZ之间的相似度是abs((AB - UV)^2 + (CD - WX)^2 + (EF - YZ)^2)。
 * <p>
 * 给定颜色#ABCDEF，返回与#ABCDEF最相似（即相似度最小）且可以简写表示的7字符颜色（也就是说，它可以用类似#XYZ的形式表示）。
 *
 * @author HughesLou
 * Created on 2022-04-20
 */
public class SimilarRGBColor1017 implements Easy {
    /**
     * 形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可
     *
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    public String similarRGB(String color) {
        return "#" + helper(color.substring(1, 3)) + helper(color.substring(3, 5)) + helper(color.substring(5));
    }

    // 因为r,g,b每一个数都是16进制，所以只要得到每一个r,g,b的两位十六进制数，
    // 然后比较转换第一位还是第二位就好。我们知道最后的结果必须是AA，所以最后的结果是17的倍数。
    // 很明显，如果这个数n除以17的余数大于8，那么这个数距离 (n / 17 + 1) * 17更近
    private String helper(String s) {
        int c = Integer.parseInt(s, 16);
        c = c / 17 + (c % 17 > 8 ? 1 : 0);
        return String.format("%02x", c * 17);
    }
}