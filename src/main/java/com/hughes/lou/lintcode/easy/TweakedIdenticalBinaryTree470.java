package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * 检查两棵二叉树是否在经过若干次扭转后可以等价。
 * 扭转的定义是，交换任意节点的左右子树。等价的定义是，两棵二叉树必须为相同的结构，并且对应位置上的节点的值要相等。
 *
 * @author HughesLou
 * Created on 2022-03-30
 */
public class TweakedIdenticalBinaryTree470 implements Easy {

    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)
                || isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left);
    }
}
