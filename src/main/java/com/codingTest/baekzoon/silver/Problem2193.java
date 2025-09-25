package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 *  1
 *  10
 *  100 101
 *  1000 1001 1010
 *  10000 10001 10010 10100 10101
 */
public class Problem2193 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        dp[1] = 1;
        if(N > 1) {
            dp[2] = 1;
        }

        for(int i = 3; i <= N; i++) {
             dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
