package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * ▣ 문제: 백준: 9461 - 파도반 수열
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. Max로 DP셋팅
 * 2. 셋팅만 O(P(N)) 조회는 O(1)
 */
public class Problem9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // test case
        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        int max = 0;
        for(int i = 0; i < T; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, testCase[i]);
        }

        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= max; ++i) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for(int M: testCase) {
            bw.write(dp[M] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
