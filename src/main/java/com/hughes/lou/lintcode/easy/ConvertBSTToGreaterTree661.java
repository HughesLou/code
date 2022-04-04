package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 给定二叉搜索树(BST)，将其转换为更大的树，
 * 使原始BST上每个节点的值都更改为在原始树中大于等于该节点值的节点值之和(包括该节点)。
 *
 * @author HughesLou
 * Created on 2022-04-02
 */
public class ConvertBSTToGreaterTree661 implements Easy {
    /**
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        travel(root, 0);
        return root;
    }

    /**
     * @param root: the node that is traveled
     * @param sum: the reference of the sum value from largest to smallest
     */
    private int travel(TreeNode root, int sum) {
        // 递归出口
        if (root == null) {
            return sum;
        }
        // 先遍历右子树
        sum = travel(root.right, sum);

        // 先加上大于等于这个数的和，并令sum加上这个数
        sum += root.val;
        root.val = sum;

        // 再遍历左子树
        sum = travel(root.left, sum);

        return sum;
    }
}
