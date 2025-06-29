package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-04-01
 */
public class MaximumSubtree628 implements Easy {
    int maxSum;
    TreeNode maxRoot;

    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxRoot = null;
        getMax(root);
        return maxRoot;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = getMax(root.left) + getMax(root.right) + root.val;
        if (sum > maxSum) {
            maxSum = sum;
            maxRoot = root;
        }

        return sum;
    }
}
