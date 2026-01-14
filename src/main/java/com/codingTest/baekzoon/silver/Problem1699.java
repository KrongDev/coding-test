package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * ▣ 문제: 백준: 1699 - 제곱수의 합
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i] = i;
            for(int j = 1; j*j <= i; j++) {
                int current = dp[i - (j * j)] + 1;
                if(dp[i] > current) {
                    dp[i] = current;
                }
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
