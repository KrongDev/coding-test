package com.codingTest.leetcode.hard;

import java.util.Stack;

public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
                continue;
            }
            stack.pop();
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int currentLength = i - stack.peek();
                res = Math.max(res, currentLength);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String str = "()(()()";
        Longest_Valid_Parentheses solution = new Longest_Valid_Parentheses();
        System.out.println(solution.longestValidParentheses(str));
    }
}
