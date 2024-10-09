package com.codingTest.baekzoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Problem2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        Stack<Integer> stack = new Stack<>();

        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = size - 1; i >= 0; i--) {
            int now = data[i];

            while (!stack.isEmpty()) {
                int index = stack.pop();
                if(now > data[index]) {
                    arr[index] = i;
                } else {
                    stack.push(index);
                    break;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(arr[i] + 1).append(" ");
        }
        System.out.println(sb);
    }
}
