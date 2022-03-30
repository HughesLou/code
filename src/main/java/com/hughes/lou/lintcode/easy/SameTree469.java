package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class SameTree469 implements Easy {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
        return false;
    }
}
