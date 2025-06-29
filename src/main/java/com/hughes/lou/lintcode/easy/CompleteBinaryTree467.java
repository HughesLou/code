package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * 判断一个二叉树是否是完全二叉树。一个完整的二叉树是一个二叉树，除了最深的一级之外，每一级都是完整的。
 * 在最深层，所有节点都必须尽可能地保留。查看更多定义
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class CompleteBinaryTree467 implements Easy {

    /**
     * @param root: the root of binary tree.
     * @return: true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node == null) {
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        int index = list.size() - 1;
        // 把最底层的null剔除
        while (list.get(index--) == null) {
        }
        while (index > 0) {
            if (list.get(index--) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isComplete1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean end = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                // 如果我们遇到了NULL，代表树必须要结束了
                end = true;
            } else {
                if (end) {
                    // 在遇到了NULL 之后居然还有非NULL的NODE， 树一定不是完整的树
                    return false;
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }
}
