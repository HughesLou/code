package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;


public class FindTheDuplicateNumber_287_Medium implements Medium {

    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println(slow);
            System.out.println(fast);
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int result = new FindTheDuplicateNumber_287_Medium().findDuplicate(nums);
        System.out.println();
        System.out.println(result);
    }
}
