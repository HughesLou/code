package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 翻转游戏：给定一个只包含两种字符的字符串：+和-。你可以将两个连续的“++”翻转成"--"，
 * 你需要翻转一次，并找到翻转后所有可能得到的结果。
 * <p>
 * 编写一个程序，找到字符串在一次有效翻转后的所有可能状态。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class FlipGame914 implements Easy {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0; ) {
            list.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        return list;
    }
}