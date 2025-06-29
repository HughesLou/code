package com.hughes.lou.lintcode.easy;

import java.util.HashSet;
import java.util.Set;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.ParentTreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-30
 */
public class LowestCommonAncestor474 implements Easy {
    /**
     * 建立集合parentSet，用于存储A的祖先节点。
     * 首先，从A向上遍历到root，将路径中的节点都存储到parentSet中。
     * 然后，从B向上遍历，判断经过的每个节点是否同时也在parentSet中，第一个出现在parentSet中的点即为A和B的最近公共祖先。
     *
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        Set<ParentTreeNode> parentSet = new HashSet<>();
        ParentTreeNode curr = A;
        while (curr != null) {
            parentSet.add(curr);
            curr = curr.parent;
        }

        curr = B;
        while (curr != null) {
            if (parentSet.contains(curr)) {
                return curr;
            }
            curr = curr.parent;
        }
        return null;
    }

    public ParentTreeNode lowestCommonAncestorII1(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        ParentTreeNode p1 = A, p2 = B;
        // 通过不断循环实现，前提是节点都确定在树中
        while (p1 != p2) {
            p1 = p1.parent == null ? B : p1.parent;
            p2 = p2.parent == null ? A : p2.parent;
        }
        return p1;
    }
}
