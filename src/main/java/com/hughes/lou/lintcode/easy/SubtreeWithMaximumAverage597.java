package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.TreeNode;

/**
 * @author HughesLou
 * Created on 2022-04-01
 */
public class SubtreeWithMaximumAverage597 implements Easy {
    float maxAvg;
    TreeNode maxRoot;

    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        maxAvg = Float.MIN_VALUE;
        maxRoot = null;
        getAverage(root);
        return maxRoot;
    }

    private float[] getAverage(TreeNode root) {
        if (root == null) {
            return new float[] {0f, 0f};
        }

        float[] ans = new float[2];
        float[] left = getAverage(root.left);
        float[] right = getAverage(root.right);
        ans[0] = left[0] + right[0] + root.val;
        ans[1] = left[1] + right[1] + 1;

        float avg = ans[0] / ans[1];
        // maxRoot == null 判断是否刚开始处理
        if (maxRoot == null || avg > maxAvg) {
            maxAvg = avg;
            maxRoot = root;
        }

        return ans;
    }
}
