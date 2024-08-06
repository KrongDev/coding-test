package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int def = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        queue.add(-1);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if(num == -1) {
                def++;
                queue.add(-1);
                continue;
            }
            if(num < 2) {
                break;
            }
            if(num%3 ==0)queue.add(num/3);
            if(num%2 ==0)queue.add(num/2);
            queue.add(num-1);
        }
        System.out.println(def);
    }
}
