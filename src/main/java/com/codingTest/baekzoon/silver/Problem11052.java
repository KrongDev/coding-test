package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 11052 - 카드 구매하기
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N^2)
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-i]+p[i]);
                }
            }
        }
        bw.write(dp[N][N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
