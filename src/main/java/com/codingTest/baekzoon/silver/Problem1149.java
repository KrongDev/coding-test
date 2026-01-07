package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] score = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        // 초기값 처리
        for(int i = 0; i < 3; i++) {
            dp[0][i] = score[0][i];
        }

        // 현재 색칠할 집
        // 즉, 이전 색칠한 3가지 케이스 중 본인과 중복되지 않는 값들 중 min값과 합쳐서 저장
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + score[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + score[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + score[i][2];
        }

        int res = dp[N-1][0];
        res = Math.min(res, dp[N-1][1]);
        res = Math.min(res, dp[N-1][2]);

        System.out.println(res);
    }
}
