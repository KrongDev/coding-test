package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int rank = 0;
        Stack<Integer> space = new Stack<>();
        for(int i = 0; i < len; i++) {
            int now = Integer.parseInt(arr[i]);
            boolean check = false;
            if(rank + 1 == now) {
                rank++;
                check = true;
            }

            while (!space.isEmpty()) {
                int prev = space.pop();
                if(rank + 1 == prev) {
                    rank++;
                    continue;
                }
                space.push(prev);
                break;
            }
            if(!check) {
                space.push(now);
            }
        }

        System.out.println(rank == len ? "Nice" : "Sad");
    }
}
