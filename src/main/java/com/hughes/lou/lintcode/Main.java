/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;

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

    public static void main(String[] args) throws Exception{
        String base = "83000224,83000240";
        String test = "83000240";
        boolean result;
        if (base.contains(test)) {
            result = true;
        } else {
            result = false;
        }

        String v0 = "4.3";
        String v1 = "4.1.3.5";
        String v2 = "4.1.3";
        String v3 = "4.2";
        String v4 = "3.1.3.5";
        String v5 = "6.1";
        String v6 = "14.1.3.5";

        System.out.println(compareVersion(v0, v1));
        System.out.println(compareVersion(v0,v2));
        System.out.println(compareVersion(v0,v3));
        System.out.println(compareVersion(v0,v4));
        System.out.println(compareVersion(v0,v5));
        System.out.println(compareVersion(v0,v6));
    }

    public static int compareVersion(String version1, String version2) throws Exception {
        if (version1 == null || version2 == null) {
            throw new Exception("compareVersion error:illegal params.");
        }
        String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；  
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；  
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }
}
