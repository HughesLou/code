package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

public class NumberOfProvinces_547_Medium implements Medium {

    public int findNum(int[][] M) {
        int n = M.length;
        int res = 0;
        boolean[] hasFind = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasFind[i]) {
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int i, boolean[] hasFind) {
        hasFind[i] = true;
        int n = M.length;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !hasFind[j]) {
                dfs(M, j, hasFind);
            }
        }
    }
}
