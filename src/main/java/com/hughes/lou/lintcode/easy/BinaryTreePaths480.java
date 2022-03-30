package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class BinaryTreePaths480 implements Easy {

    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }

        return paths;
    }
}
