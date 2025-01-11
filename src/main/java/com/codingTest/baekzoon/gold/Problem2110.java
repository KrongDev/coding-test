package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.Arrays;

public class Problem2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int min = 1;
        int max = houses[N - 1] - houses[0];
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 1;
            int lastInstalled = houses[0];

            for (int i = 1; i < N; i++) {
                if (houses[i] - lastInstalled >= mid) {
                    count++;
                    lastInstalled = houses[i];
                }
            }

            if (count >= C) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
