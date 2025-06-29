package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.hughes.lou.level.Easy;

/**
 * 有一个圆环上面有6个点，每一个点都有一个数字，对于两个圆环来说，若6个数字完全一致（顺序可以随
 * 机，只要数相同即可），则说明这两个圆环是一样的，现在有n个圆环，想问你这里面有没有一样的两
 * 个圆环，若有返回true，反之返回false。
 *
 * @author HughesLou
 * Created on 2022-03-29
 */
public class Circle343 implements Easy {

    /**
     * @param circles: The value of 6 points on n rings
     * @return: Whether there are two same circles
     */
    public boolean samecircle(int[][] circles) {
        Map<String, Integer> contentMap = new HashMap<>();
        for (int[] circle : circles) {
            String content = IntStream.of(circle).sorted().mapToObj(String::valueOf).collect(Collectors.joining(";"));
            if (contentMap.containsKey(content)) {
                return true;
            } else {
                contentMap.put(content, 1);
            }
        }
        return false;
    }
}
