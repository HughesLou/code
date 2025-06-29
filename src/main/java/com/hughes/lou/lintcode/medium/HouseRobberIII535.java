package com.hughes.lou.lintcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Medium;
import com.hughes.lou.model.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，
 * 但这次所有的房子组成的区域比较奇怪，聪明的窃贼考察地形之后，发现这次的地形是一颗二叉树。
 * 与前两次偷窃相似的是每个房子都存放着特定金额的钱。
 * 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * <p>
 * 算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。
 *
 * @author HughesLou
 * Created on 2022-05-21
 */
public class HouseRobberIII535 implements Medium {

    Map<TreeNode, Integer> memo = new HashMap<>();

    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢，然后去下下家
        int do_it = root.val
                + (root.left == null ? 0 : houseRobber3(root.left.left) + houseRobber3(root.left.right))
                + (root.right == null ? 0 : houseRobber3(root.right.left) + houseRobber3(root.right.right));
        // 不抢，然后去下家
        int not_do = houseRobber3(root.left) + houseRobber3(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }

    // 返回一个大小为 2 的数组 arr
    // arr[0] 表示不抢 root 的话，得到的最大钱数
    // arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {not_rob, rob};
    }
}