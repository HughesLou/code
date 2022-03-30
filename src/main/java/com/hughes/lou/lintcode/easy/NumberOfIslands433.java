/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.Coordinate;

/**
 * Created by Hughes on 2018/1/20 16:03.
 */
public class NumberOfIslands433 implements Easy {
    /**
     * BFS
     * add visited to reduce process
     *
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (grid[i][j]) {
                        markByBFS(grid, i, j, visited);
                        ++islands;
                    }
                }
            }
        }
        return islands;
    }

    private void markByBFS(boolean[][] grid, int x, int y, boolean[][] visited) {
        // four directions, right, down, up, left
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;
        int newX, newY;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                newX = coordinate.x + directionX[i];
                newY = coordinate.y + directionY[i];

                if (inBound(newX, newY, grid) && !visited[newX][newY]) {
                    visited[newX][newY] = true;

                    if (grid[newX][newY]) {
                        grid[newX][newY] = false;
                        queue.offer(new Coordinate(newX, newY));
                    }
                }
            }
        }
    }

    private boolean inBound(int newX, int newY, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return newX >= 0 && newX < n && newY >= 0 && newY < m;
    }

    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands1(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int islands = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (isIsland(grid, row, col, visited, n, m)) {
                    visited[row][col] = true;
                    dfs(grid, row, col, visited, n, m);
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean isIsland(boolean[][] grid, int x, int y, boolean[][] visited, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (!grid[x][y]) {
            return false;
        }
        return !visited[x][y];
    }

    private void dfs(boolean[][] grid, int x, int y, boolean[][] visited, int n, int m) {
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        for (int direction = 0; direction < 4; direction++) {
            int newX = x + dx[direction];
            int newY = y + dy[direction];

            if (isIsland(grid, newX, newY, visited, n, m)) {
                visited[newX][newY] = true;
                dfs(grid, newX, newY, visited, n, m);
            }
        }
    }
}