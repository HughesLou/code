package com.hughes.lou.lintcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class BinaryTreeLevelOrderTraversal69 implements Easy {

    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<ArrayList<Integer>> result = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode last = new TreeNode(0);
        queue.add(last);
        ArrayList<Integer> currentLevel = new ArrayList<>();
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (node != last) {
                currentLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                result.addFirst(new ArrayList<>(currentLevel));
                currentLevel.clear();
                queue.add(last);
            }
        }
        result.addFirst(currentLevel);
        return new ArrayList<>(result);
    }
}
