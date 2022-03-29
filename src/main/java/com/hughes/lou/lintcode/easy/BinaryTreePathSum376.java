package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-29
 */
public class BinaryTreePathSum376 implements Easy {

    /**
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     * we will sort your return value in output
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> rootList = new ArrayList<>();
            rootList.add(root.val);
            result.add(rootList);
            return result;
        }
        // Divide
        List<List<Integer>> leftResult = binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> rightResult = binaryTreePathSum(root.right, target - root.val);
        // Merge results
        for (List<Integer> l : leftResult) {
            l.add(0, root.val);
            result.add(l);
        }
        for (List<Integer> r : rightResult) {
            r.add(0, root.val);
            result.add(r);
        }
        return result;
    }

    public List<List<Integer>> binaryTreePathSum1(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> candidateList = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;

        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                sum += cur.val;
                candidateList.add(cur.val);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.peek();
                boolean canPop = cur.right == null || cur.right == pre;
                pre = cur;
                if (canPop) {
                    if (sum == target && cur.left == null && cur.right == null) {
                        res.add(new ArrayList<>(candidateList));
                    }
                    sum -= cur.val;
                    stack.pop();
                    candidateList.remove(candidateList.size() - 1);
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
