package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * ▣ 문제: : 백준 - 동물원 1309
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1. 1 = 2
 * 2. 2 = 6
 * 3. 3 = 24
 */
public class Problem1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        long result = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
