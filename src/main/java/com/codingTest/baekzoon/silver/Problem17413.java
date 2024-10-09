package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(char c : str.toCharArray()) {
            if(c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
                flag = true;
                continue;
            }

            if(c == '>') {
                flag = false;
                sb.append(c);
                continue;
            }

            if(flag) {
                sb.append(c);
                continue;
            }

            if(c == ' ') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                continue;
            }

            stack.push(c);
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
