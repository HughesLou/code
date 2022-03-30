package com.hughes.lou.lintcode.easy;

import java.util.Stack;

import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 将一棵二叉树按照前序遍历拆解成为一个 假链表。
 * 所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class FlattenBinaryTreeToLinkedList453 {
    private TreeNode lastNode = null;

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        // root会在后续处理中发生变化
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    /**
     * 非递归的解法。不断将左子树拆下来接到右边去。然后将左子树与右子树连接。
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
                TreeNode right = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode node = root.right;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = right;
            }
            root = root.right;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            // connect
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}
