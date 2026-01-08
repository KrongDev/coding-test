package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1932 - 정수 삼각형
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. dp[i][j]의 이전은 dp[i-1][j-1], dp[i-1][j] 이다.
 * 2.
 */
public class Problem1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];
        int[][] score = new int[N + 1][N + 1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = score[1][1];

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + score[i][j];
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[N][i]);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
