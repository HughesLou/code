package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class FindTheMaximum297 implements Naive {

    /**
     * @param nums: the list of numbers
     * @return: return the maximum number.
     */
    public int maxNum(List<Integer> nums) {
        int max = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > max) {
                max = nums.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        for (String element : a.split(" ")) {
            list.add(Integer.parseInt(element));
        }

        FindTheMaximum297 findTheMaximum297 = new FindTheMaximum297();
        System.out.println(findTheMaximum297.maxNum(list));
    }
}