package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 我们有两个特殊的字符。第一个字符可以用一位 0 来表示。第二个字符可以用两位(10 或者 11)表示。
 * <p>
 * 现在给出一个字符串表示若干位。返回最后一个字符是否必定为一位字符。给出的字符串总是以 0 结尾。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class BitAnd2BitCharacters973 implements Easy {

    /**
     * 从头到尾遍历，如果该位数字为1，则向后前进两位，否则前进1位，循环的条件是i < n-1，即留出最后一位.
     * 当循环退出后，i正好停留在n-1上，说明最后一位是单独分割开的。
     */
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == n - 1;
    }
}
