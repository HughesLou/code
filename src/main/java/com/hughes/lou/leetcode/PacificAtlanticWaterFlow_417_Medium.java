package com.hughes.lou.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow_417_Medium {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        dfs(matrix, visited, matrix[x][y], x + 1, y);
        dfs(matrix, visited, matrix[x][y], x - 1, y);
        dfs(matrix, visited, matrix[x][y], x, y + 1);
        dfs(matrix, visited, matrix[x][y], x, y - 1);
    }
}
