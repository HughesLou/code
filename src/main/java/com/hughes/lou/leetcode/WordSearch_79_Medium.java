package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class WordSearch_79_Medium implements Medium {
    private static final int[][] shift = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) return true;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int start, int r, int c) {
        if (start == word.length()) {
            return true;
        }
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(start) || visited[r][c]) {
            return false;
        }
        visited[r][c] = true;
        for (int[] ints : shift) {
            if (dfs(board, word, start + 1, r + ints[0], c + ints[1])) return true;
        }
        visited[r][c] = false;
        return false;
    }
}
