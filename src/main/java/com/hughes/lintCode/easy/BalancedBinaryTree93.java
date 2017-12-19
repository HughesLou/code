/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

package com.hughes.lintCode.easy;

import com.hughes.lintCode.model.TreeNode;

/**
 * Created by luzhiwei01 on 2017/12/17 23:04.
 */
public class BalancedBinaryTree93 {

    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
