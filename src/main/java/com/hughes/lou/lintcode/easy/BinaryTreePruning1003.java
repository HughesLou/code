package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 给定二叉树的根节点，树上每个节点的值是0或1。
 * 返回这棵树，其中每个不包含1的子树已被删除。
 *
 * @author HughesLou
 * Created on 2022-04-07
 */
public class BinaryTreePruning1003 implements Easy {
    /**
     * @param root: the root
     * @return: the same tree where every subtree (of the given tree) not containing a 1 has been removed
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
}
