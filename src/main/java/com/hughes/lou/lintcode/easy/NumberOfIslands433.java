/*
 * Copyright (C) 2018 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.hughes.lou.lintcode.level.Easy;

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
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
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

                    Coordinate around = new Coordinate(newX, newY);
                    if (grid[around.x][around.y]) {
                        grid[around.x][around.y] = false;
                        queue.offer(around);
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

    private boolean inBound(Coordinate coordinate, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return coordinate.x >= 0 && coordinate.x < n && coordinate.y >= 0 && coordinate.y < m;
    }
}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
