package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 给定一个长为n的数组Ages, 其中第i个元素表示第i个人的年龄。求这个n个人，发送的好友请求的总数。其中，
 * <p>
 * 如果Age(B) <= (1/2)Age(A) + 7, A不会给B发请求
 * 如果Age(B) > Age(A)， A不会给B发请求
 * 如果Age(B) < 100 and Age(A) > 100, A不会给B发请求
 * 不满足1，2，3，则A会给B发请求。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class FriendRequest895 implements Easy {
    /**
     * @param ages: The ages
     * @return: The answer
     */
    public int friendRequest(int[] ages) {
        int result = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                int A = ages[i], B = ages[j];
                if (i == j || B <= A / 2 + 7 || B > A || (B < 100 && A > 100)) {
                    continue;
                }
                result++;
            }
        }
        return result;
    }
}
