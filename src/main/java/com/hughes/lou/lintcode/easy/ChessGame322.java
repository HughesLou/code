package com.hughes.lou.lintcode.easy;

import java.util.HashMap;

import com.hughes.lou.level.Easy;

/**
 * 在棋盘上
 * 给定一个长度为N的二元数组queen，代表N个皇后棋子的坐标
 * 给定一个长度为M的二元数组knight，代表M个骑士棋子的坐标
 * 每个皇后可以袭击同行，同列，或者同对角线的任意一个骑士棋子
 * 请你返回一个长度为M的答案数组，依次代表每个骑士棋子是否会被攻击到
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class ChessGame322 implements Easy {

    /**
     * 用四个数组或者哈希表分别记录行、列、主对角线和副对角线中是否存在皇后，再去遍历每个骑士即可。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(max(n,m))
     * n为皇后的数量，m为骑士的数量，因为需要遍历每一个皇后和骑士的坐标，故复杂度由两者中较大的一个决定。
     * <p>
     * 空间复杂度：O(n)
     * 每个皇后的坐标都需要记录。
     *
     * @param queen: queen‘coordinate
     * @param knight: knight‘coordinate
     * @return: if knight is attacked please return true，else return false
     */
    public boolean[] isAttacked(int[][] queen, int[][] knight) {
        HashMap<Integer, Boolean> row = new HashMap<>(), column = new HashMap<>(),
                diagonal = new HashMap<>(), diagonal2 = new HashMap<>();

        for (int[] pos : queen) {
            row.put(pos[0], true);
            column.put(pos[1], true);
            diagonal.put(pos[1] - pos[0], true);
            diagonal2.put(pos[1] + pos[0], true);
        }

        int m = knight.length;
        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (row.containsKey(knight[i][0])) {
                result[i] = true;
                continue;
            }
            if (column.containsKey(knight[i][1])) {
                result[i] = true;
                continue;
            }
            if (diagonal.containsKey(knight[i][1] - knight[i][0])) {
                result[i] = true;
                continue;
            }
            if (diagonal2.containsKey(knight[i][1] + knight[i][0])) {
                result[i] = true;
            }
        }
        return result;
    }
}
