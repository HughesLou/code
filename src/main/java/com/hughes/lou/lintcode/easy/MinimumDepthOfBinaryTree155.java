package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 二叉树的最小深度为根节点到最近叶子节点的最短路径上的节点数量。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class MinimumDepthOfBinaryTree155 implements Easy {

    /**
     * 要判断一下左右子树是否有空子树，如果有，那么最小深度等于另一颗子树的深度加1
     *
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 当左子树或右子树为空时，最小深度取决于另一颗子树
        if (leftDepth == 0 || rightDepth == 0){
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
