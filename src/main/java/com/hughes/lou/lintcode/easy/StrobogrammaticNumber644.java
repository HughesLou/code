package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.hughes.lou.level.Easy;

/**
 * 镜像数字
 * <p>
 * 一个镜像数字是指一个数字旋转180度以后和原来一样(倒着看)。
 * 例如，数字"69"，"88"，和"818"都是镜像数字。
 * 写下一个函数来判断是否这个数字是镜像的。数字用字符串来表示。
 *
 * @author HughesLou
 * Created on 2022-04-02
 */
public class StrobogrammaticNumber644 implements Easy {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');

        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
