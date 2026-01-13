package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 11722 - 가장 긴 감소하는 부분 수열
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(score[i] < score[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
