package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int strLen = str.length();

        double[] arr = new double[len];
        for(int i = 0; i < len; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                stack.push(arr[ch - 'A']);
                continue;
            }

            double b = stack.pop();
            double a = stack.pop();
            switch (ch) {
                case '+':
                    stack.push(a + b);
                    break;
                case '-':
                    stack.push(a - b);
                    break;
                case '*':
                    stack.push(a * b);
                    break;
                case '/':
                    stack.push(a / b);
                    break;
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
