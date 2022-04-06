package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class ClosestBinarySearchTreeValue900 implements Easy {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        TreeNode upper = root;
        TreeNode lower = root;

        while (root != null) {
            if (root.val > target) {
                upper = root;
                root = root.left;
            } else if (root.val < target) {
                lower = root;
                root = root.right;
            } else {
                return root.val;
            }
        }

        if (Math.abs(upper.val - target) > Math.abs(target - lower.val)) {
            return lower.val;
        }
        return upper.val;
    }
}
