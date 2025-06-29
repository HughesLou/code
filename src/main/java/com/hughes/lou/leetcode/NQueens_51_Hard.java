package com.hughes.lou.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51_Hard {

    private List<List<String>> ret;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nQueens[i][j] = '.';
            }
        }
        backtracking(0);
        return ret;
    }

    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(nQueens[i]));
            }
            ret.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (colUsed[i] || diagonals45Used[row + i] || diagonals135Used[row - i + n - 1]) {
                continue;
            }
            colUsed[i] = true;
            diagonals45Used[row + i] = true;
            diagonals135Used[row - i + n - 1] = true;
            nQueens[row][i] = 'Q';
            backtracking(row + 1);
            nQueens[row][i] = '.';
            colUsed[i] = false;
            diagonals45Used[row + i] = false;
            diagonals135Used[row - i + n - 1] = false;
        }
    }
}
