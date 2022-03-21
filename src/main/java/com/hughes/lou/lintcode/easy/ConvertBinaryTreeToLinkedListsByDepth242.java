package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.ListNode;
import com.hughes.lou.lintcode.model.TreeNode;

/**
 * 将二叉树按照层级转化为链表
 * <p>
 * 给一棵二叉树，设计一个算法为每一层的节点建立一个链表。
 * 也就是说，如果一棵二叉树有 D 层，那么你需要创建 D 条链表。
 *
 * @author HughesLou
 * Created on 2022-03-21
 */
public class ConvertBinaryTreeToLinkedListsByDepth242 implements Easy {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;

                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(dummy.next);
        }

        return result;
    }

    public List<ListNode> binaryTreeToLists0(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        dfs(root, 1, result);
        return result;
    }

    void dfs(TreeNode root, int depth, List<ListNode> result) {
        if (root == null) {
            return;
        }
        ListNode node = new ListNode(root.val);
        if (result.size() < depth) {
            result.add(node);
        } else {
            node.next = result.get(depth - 1);
            result.set(depth - 1, node);
        }
        dfs(root.right, depth + 1, result);
        dfs(root.left, depth + 1, result);
    }
}