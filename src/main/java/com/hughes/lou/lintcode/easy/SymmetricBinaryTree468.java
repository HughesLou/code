package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 给你一颗二叉树，判断是否是对称二叉树（即，围绕其中心对称）
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class SymmetricBinaryTree468 implements Easy {

    /**
     * @param root: the root of binary tree.
     * @return: true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }
}
