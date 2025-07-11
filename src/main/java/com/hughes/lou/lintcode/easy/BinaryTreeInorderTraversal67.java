package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * 给出一棵二叉树，返回其节点值的中序遍历。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class BinaryTreeInorderTraversal67 implements Easy {

    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}
