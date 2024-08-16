package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1010 {
    final static int MAX = 30;
    static int[][] dp = new int[MAX + 1][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        genDp();
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            bw.write(dp[M][N] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void genDp() {
        for(int i = 1; i <= MAX; i++)
            dp[i][1] = i;

        for(int j = 2; j <= MAX; j++)
            for(int k = 2; k <=MAX; k++)
                dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
    }
}
