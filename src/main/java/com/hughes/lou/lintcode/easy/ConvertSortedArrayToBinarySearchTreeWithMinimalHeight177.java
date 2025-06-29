package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-03-20
 */
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight177 implements Easy {

    /*
     * 每次取middle作为根，左半边是左子树，右半边是右子树。 递归处理左右两边。
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        return helper(A, 0, A.length);
    }

    private TreeNode helper(int[] A, int start, int excludedEnd) {
        if (start >= excludedEnd) {
            return null;
        }
        int mid = (start + excludedEnd - 1) >> 1;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, start, mid);
        node.right = helper(A, mid + 1, excludedEnd);
        return node;
    }
}
