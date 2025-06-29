package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-04-02
 */
public class BinaryTreeMaximumNode632 implements Easy {
    /**
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode maxLeft = maxNode(root.left);
        TreeNode maxRight = maxNode(root.right);

        int leftVal = maxLeft == null ? Integer.MIN_VALUE : maxLeft.val;
        int rightVal = maxRight == null ? Integer.MIN_VALUE : maxRight.val;

        if (root.val > leftVal && root.val > rightVal) {
            return root;
        } else if (leftVal > rightVal) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }

    TreeNode max(TreeNode a, TreeNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val > b.val) {
            return a;
        }
        return b;
    }
}
