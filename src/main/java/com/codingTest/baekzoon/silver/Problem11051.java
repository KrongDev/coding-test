package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 11051 - 이항 계수 2
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N*K)
 * * [풀이 전략]
 * 1
 * 11
 * 121
 * 1331
 * 14641
 */
public class Problem11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] dp = new int[N + 1][K + 2];

        dp[0][1] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K + 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j])%10007;
            }
        }

        bw.write(dp[N][K + 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
