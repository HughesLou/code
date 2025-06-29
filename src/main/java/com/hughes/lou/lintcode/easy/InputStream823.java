package com.hughes.lou.lintcode.easy;

import java.util.Stack;

import com.hughes.lou.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-05
 */
public class InputStream823 implements Easy {
    /**
     * @param inputA: Input stream A
     * @param inputB: Input stream B
     * @return: The answer
     */
    public String inputStream(String inputA, String inputB) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        char key = '<';
        for (Character c : inputA.toCharArray()) {
            if (c != key) {
                stackA.push(c);
            } else if (!stackA.isEmpty()) {
                stackA.pop();
            }
        }
        for (Character c : inputB.toCharArray()) {
            if (c != key) {
                stackB.push(c);
            } else if (!stackB.isEmpty()) {
                stackB.pop();
            }
        }
        if (stackA.size() != stackB.size()) {
            return "NO";
        }
        // 双栈弹出字符若不同，输入流结果则不同
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.pop() != stackB.pop()) {
                return "NO";
            }
        }
        return "YES";
    }
}
