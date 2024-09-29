package com.codingTest.programers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < len; i++) {
            char now = s.charAt(i);
            char prev = stack.pop();
            if (stack.isEmpty() || now != prev) {
                stack.push(now);
                continue;
            }

            stack.push(now);
        }


        return stack.isEmpty() ? 1 : 0;
    }
}
