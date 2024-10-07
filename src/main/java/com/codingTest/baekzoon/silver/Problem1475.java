package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[10];
        for(char c: str.toCharArray()){
            if(c == '6' && arr[9] < arr[6]) {
                 arr[9]++;
                 continue;
            }
            if(c == '9' && arr[9] > arr[6]) {
                 arr[6]++;
                 continue;
            }

            arr[c - '0']++;

        }
        int res = 0;
        for(int a: arr) {
            res = Math.max(res, a);
        }
        System.out.println(res);
    }
}
