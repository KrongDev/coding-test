package com.codingTest.baekzoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();
        int boomLen = boom.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= boomLen) {
                boolean isBoom = true;
                for (int j = 0; j < boomLen; j++) {
                    if (stack.get(stack.size() - boomLen + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    for (int j = 0; j < boomLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
