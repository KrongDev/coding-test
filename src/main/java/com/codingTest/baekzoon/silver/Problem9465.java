package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 9465 - 스티커
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while((T--)>0) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[n][2];
            for(int c = 0; c < 2; c++) {
                st = new StringTokenizer(br.readLine());
                for(int i = 0; i < n; i++) {
                    scores[i][c] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[n][2];
            dp[0][0] = scores[0][0];
            dp[0][1] = scores[0][1];

            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + scores[i][0]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0] + scores[i][1]);
            }

            bw.write(Math.max(dp[n-1][0], dp[n-1][1]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
