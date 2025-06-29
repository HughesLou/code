package com.hughes.lou.lintcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class BinaryTreeLevelSum482 implements Easy {

    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        if (root == null || level < 1) {
            return 0;
        }
        if (level == 1) {
            return root.val;
        }
        return levelSum(root.left, level - 1) + levelSum(root.right, level - 1);
    }

    public int levelSum1(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1, sum = 0;
        queue.offer(root);
        while (!queue.isEmpty() && count < level) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

        }
        if (count == level) {
            while (!queue.isEmpty()) {
                sum += queue.poll().val;
            }
        }
        return sum;
    }
}
