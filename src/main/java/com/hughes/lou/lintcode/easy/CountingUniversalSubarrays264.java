package com.hughes.lou.lintcode.easy;

import java.util.Stack;

import com.hughes.lou.level.Easy;

/**
 * 通用子数组个数
 * <p>
 * 给定一个由 2 或 4 组成的数组。如果一个数组的子数组 (子数组是数组中相邻的一组元素且不能为空) 符合以下条件，则称为“通用”:
 * 2 和 4 被连续分组(如[4, 2],[2, 4],[4, 4, 2, 2],[2, 2, 4, 4],[4, 4, 4, 2, 2, 2]等等)。
 * 子数组中 4 的个数等于子数组中 2 的个数。
 * 相同元素但位置不同的子数组视为不同，如数组[4, 2, 4, 2]中有两个[4, 2]子数组。
 * 你需要返回一个整数值，即给定数组中“通用”子数组的数量。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class CountingUniversalSubarrays264 implements Easy {
    /**
     * 1、用stack来count, 现在有两个形状，一个是4,2顺序 一个是2，4顺序； 这两个顺序分别计算下有多少个加起来就行了；
     * 2、stack原理：例如 2,2,4,4； 我们来找2,4顺序的，left就是2 首先依次遍历 如果碰到等于left的放在stack里面，然后遍历到4了，现在stack存的是【2,
     * 2】，和一个4匹配，那么一个2弹出栈，并且count+1；再来遍历一个4，和剩下的2匹配，count+1， 那么总的数量就是2了；
     * 【注意】 如果遍历到4后面发现是2后我们就要清空stack，为了避免224244 计成3个的情况 实际上只有2个，
     * 因为如果在index=2时候不清空stack，那么stack里面还剩一个2，在index = 5的时候又和4匹配 就会多算一个；
     * 3、 4,2顺序的跟上面同理；
     *
     * @param array: An given array.
     * @return: Return the number of "universal" subarrays.
     */
    public int subarrays(int[] array) {
        return countUniversal(2, array) + countUniversal(4, array);
    }

    public int countUniversal(int left, int[] A) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (left == A[i]) {
                stack.add(i);
            } else {
                if (!stack.isEmpty()) {
                    cnt++;
                    stack.pop();
                }
                if (i < n - 1 && A[i + 1] == left) {
                    stack.clear();
                }
            }
        }

        return cnt;
    }
}
