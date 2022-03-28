package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 字符矩阵
 * <p>
 * 给你两个字符串A和B，返回一个矩阵。串A要求从左往右输出，串B要求从上往下输出，两串交于一点（即有一个字母共用）。
 * 共用的字母要求是串A中第一个在串B也包含的字母，特别的，要求交点是两串中各自第一次出现共用的字母的位置。
 * 其余空白处要求用"."补齐（不包括引号）。比如当串A="ABBA"并且串B=“CCBB”。你需返回四行：
 * <p>
 * [“.C..”,
 * “.C..”,
 * ”ABBA“,
 * ”.B..“]
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class CharacterGrid318 implements Easy {
    /**
     * 根据题意模拟，找出A字符串中第一个在B字符串中出现的位置，分别记录下2个位置，根据2个位置去构造字符二维矩阵，
     * 记录位置时既可以用二重循环去寻找，也可以借助Hash表之类的工具进行统计。
     *
     * @param A: A string
     * @param B: A string
     * @return: A string array
     */
    public List<String> characterGrid(String A, String B) {
        int n = A.length(), m = B.length(), indexA = -1, indexB = -1;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    indexA = i;
                    indexB = j;
                    break;
                }
            }
            if (indexA != -1) {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (i == indexB) {
                result.add(A);
            } else {
                StringBuilder now = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == indexA) {
                        now.append(B.charAt(i));
                    } else {
                        now.append('.');
                    }
                }
                result.add(now.toString());
            }
        }
        return result;
    }
}
