package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * 给一棵二叉树，找到最长连续路径的长度。
 * 这条路径是指 任何的节点序列中的起始节点到树中的任一节点都必须遵循 父-子 联系。
 * 最长的连续路径必须是从父亲节点到孩子节点（不能逆序）。
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class BinaryTreeLongestConsecutiveSequence595 implements Easy {

    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }

        int length = (parent != null && parent.val + 1 == root.val)
                     ? lengthWithoutRoot + 1
                     : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }

}
