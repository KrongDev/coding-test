package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * ▣ 문제: 백준: 2156 - 포도주 시식
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. i를 아예 마시지 않을 경우 dp[i-1] + score[i]
 * 2. 이전 잔도 마신경우 dp[i-3] + score[i-1] + score[i]
 * 3. 이전 잔을 안마신경우 dp[i-2] + score[i]
 */
public class Problem2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] score = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];
        if (N >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i]);
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
