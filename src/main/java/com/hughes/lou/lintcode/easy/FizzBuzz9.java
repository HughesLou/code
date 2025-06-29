package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给定整数 n ，按照如下规则打印从 1 到 n 的每个数：
 * <p>
 * 如果这个数被3整除，打印fizz。
 * 如果这个数被5整除，打印buzz。
 * 如果这个数能同时被3和5整除，打印fizz buzz。
 * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class FizzBuzz9 implements Easy {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("fizz buzz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
