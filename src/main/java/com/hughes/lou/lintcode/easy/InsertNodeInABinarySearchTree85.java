/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * Created by hughes on 2017/12/17 22:52.
 */
public class InsertNodeInABinarySearchTree85 implements Easy {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (null == root) {
            root = node;
        } else {
            if (null != node) {
                if (root.val > node.val) {
                    root.left = insertNode(root.left, node);
                } else {
                    root.right = insertNode(root.right, node);
                }
            }
        }
        return root;
    }
}
