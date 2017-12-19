/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

package com.hughes.lintCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.swing.tree.TreeNode;

/**
 * Created by luzhiwei01 on 2017/12/17 00:02.
 */
public class Main {

//    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
//                level.add(head.val);
//                if (head.left != null) {
//                    queue.offer(head.left);
//                }
//                if (head.right != null) {
//                    queue.offer(head.right);
//                }
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        String base = "83000224,83000240";
        String test = "83000240";
        boolean result;
        if (base.contains(test)) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);

    }
}
