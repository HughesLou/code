package com.hughes.lou.leetcode;

public class SurroundedRegions_130_Medium {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 只处理四条边上的'O'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);      // 第一列
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1); // 最后一列
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);     // 第一行
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j); // 最后一行
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] == '#') ? 'O' : 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
