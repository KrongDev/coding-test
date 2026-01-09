package com.codingTest.baekzoon.gold;

import java.io.*;

/**
 * ▣ 문제: 백준: 9251 - LCS
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. 시간초 제한 0.4초
 * 2. O(N)으로 끝내야한다.
 */
public class Problem9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();

        String min = str1.length() < str2.length() ? str1 : str2;
        String max = str1.length() < str2.length() ? str2 : str1;

        int N = min.length();
        int M = max.length();

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(min.charAt(i - 1) == max.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        bw.write(dp[N][M] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
