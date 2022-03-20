package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 给出一棵二叉树，返回其节点值的后序遍历。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class BinaryTreePostorderTraversal68 implements Easy {

    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}
