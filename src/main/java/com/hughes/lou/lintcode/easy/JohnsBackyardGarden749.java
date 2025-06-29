package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 约翰想在他家后面的空地上建一个后花园，现在有两种砖，一种3 dm的高度，7 dm的高度。
 * 约翰想围成x dm的墙。如果约翰能做到，输出YES，否则输出NO。
 *
 * @author HughesLou
 * Created on 2022-04-04
 */
public class JohnsBackyardGarden749 implements Easy {
    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        int max3 = x / 3;
        int max7 = x / 7;

        for (int i = 0; i <= max3; i++) {
            for (int j = 0; j <= max7; j++) {
                if (3 * i + 7 * j == x) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    public String isBuild1(int x) {
        return canBuild(x) ? "YES" : "NO";
    }

    private boolean canBuild(int x) {
        return x == 0 || (x >= 0 && (canBuild(x - 3) || canBuild(x - 7)));
    }
}