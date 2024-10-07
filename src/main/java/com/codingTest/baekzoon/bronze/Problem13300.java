package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int maxSize = Integer.parseInt(st.nextToken());

        int[][] arr = new int[7][2];

        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            arr[age][x]++;
        }

        int res = 0;
        for(int i = 1; i < 7; i++) {
            res += arr[i][0]/maxSize + (arr[i][0]%maxSize > 0 ? 1 : 0);
            res += arr[i][1]/maxSize + (arr[i][1]%maxSize > 0 ? 1 : 0);
        }
        System.out.println(res);
    }
}
