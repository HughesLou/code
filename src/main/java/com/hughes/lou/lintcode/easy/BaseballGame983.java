package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 现在你是棒球比赛分记录员。
 * <p>
 * 给定一个字符串数组，每一个字符串可以是以下4种中的其中一个：
 * <p>
 * 整数 (一个回合的分数): 直接表示这回合你得到的分数。
 * "+" (一个回合的分数): 表示这回合你获得的分数为前两个 有效 分数之和。
 * "D" (一个回合的分数): 表示这回合你得到的分数为你上一次获得的有效分数的两倍。
 * "C" (一种操作，而非一个回合的分数): 表示你上回合的有效分数是无效的，需要移除。
 * 每一轮的操作都是永久性的，可能会影响之前和之后的一轮。
 * 你需要返回在所有回合中获得总分数。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class BaseballGame983 implements Easy {
    /**
     * @param ops: the list of operations
     * @return: the sum of the points you could get in all the rounds
     */
    public int calPoints(String[] ops) {
        int[] ar = new int[ops.length];
        int index = -1, score = 0;
        for (String op : ops) {
            char c = op.charAt(0);
            if (c == '+') {
                ar[++index] = ar[index - 1] + ar[index - 2];
                score += ar[index];
            } else if (c == 'D') {
                ar[++index] = 2 * ar[index - 1];
                score += ar[index];
            } else if (c == 'C') {
                score -= ar[index--];
            } else {
                ar[++index] = Integer.parseInt(op);
                score += ar[index];
            }
        }
        return score;
    }
}
