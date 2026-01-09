package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * ▣ 문제: 백준: 1904 - 01타일
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. 1
 * 2. 00, 11
 * 3. 100, 001, 111
 * 4. 1100, 0011, 1001, 1111, 0000
 * 5. dp[i] = dp[i-1] + dp[i-2]
 */
public class Problem1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%15746;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
