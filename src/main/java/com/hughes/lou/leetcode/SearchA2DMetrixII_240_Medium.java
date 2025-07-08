package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class SearchA2DMetrixII_240_Medium implements Medium {
    public boolean searchMatrix(int[][] grid, int target) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (grid[row][col] == target) {
                return true;
            } else if (grid[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
