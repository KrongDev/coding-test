package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 11054 - 가장 긴 바이토닉 부분 수열
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도:O(N^2)
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 0: sort
        // 1: reverse
        int[][] dp = new int[2][N];

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            dp[0][i] = 1;
            dp[1][N-1-i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[0][i] < dp[0][j] + 1){
                    dp[0][i] = dp[0][j] + 1;
                }

                int ri = N-1-i;
                int rj = N-1-j;
                if(arr[ri] > arr[rj] && dp[1][ri] < dp[1][rj] + 1){
                    dp[1][ri] = dp[1][rj] + 1;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++){
            answer = Math.max(answer, dp[0][i] + dp[1][i] - 1);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
