package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        int res = 0;

        Stack<Character> stack;
        String str;
        while (len-- > 0) {
            stack = new Stack<>();
            str = br.readLine();
            for(char c : str.toCharArray()) {
                if(stack.isEmpty()) stack.push(c);
                else {
                    char prev = stack.pop();
                    if(prev != c) {
                        stack.push(prev);
                        stack.push(c);
                    }
                }
            }
            if(stack.isEmpty()) res++;
        }

        System.out.println(res);
    }
}
