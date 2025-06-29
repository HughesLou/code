package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class BinaryTreeLeafSum481 implements Easy {

    /**
     * @param root: the root of the binary tree
     * @return: An integer
     */
    public int leafSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return leafSum(root.left) + leafSum(root.right);
    }
}
