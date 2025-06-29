package com.hughes.lou.leetcode;

import com.hughes.lou.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257_Easy {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String prefix, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(prefix + root.val);
            return;
        }
        prefix += root.val + "->";
        dfs(root.left, prefix, result);
        dfs(root.right, prefix, result);
    }
}
