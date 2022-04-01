package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-31
 */
public class MinimumSubtree596 implements Easy {
    int minSum;
    TreeNode minRoot;

    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        minSum = Integer.MAX_VALUE;
        minRoot = null;
        getSum(root);
        return minRoot;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = getSum(root.left) + getSum(root.right) + root.val;
        if (sum < minSum) {
            minSum = sum;
            minRoot = root;
        }

        return sum;
    }
}
