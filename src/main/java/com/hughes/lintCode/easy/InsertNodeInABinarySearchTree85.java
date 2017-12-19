/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

package com.hughes.lintCode.easy;

import com.hughes.lintCode.model.TreeNode;

/**
 * Created by luzhiwei01 on 2017/12/17 22:52.
 */
public class InsertNodeInABinarySearchTree85 {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
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
