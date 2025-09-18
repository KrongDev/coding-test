package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem30010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = genArr(N);

        StringBuilder sb = new StringBuilder();
        for (int val : A) {
            sb.append(val).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static int[] genArr(int N) {
        int[] arr = new int[N];
        for(int i = N; i > 0; i--) {
            arr[i%N] = i;
        }
        return arr;
    }
}
