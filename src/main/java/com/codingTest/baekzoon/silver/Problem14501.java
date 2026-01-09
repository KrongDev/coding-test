package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 14501 - 퇴사
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. 뒤부터 퇴사일(N + 1)일 까지 가장 많은 금액을 받을 수 있는 날을 구한다.
 * 2. dp[i+1] or dp[i + T[i]] 참여하거나 참여하지 않거나
 */
public class Problem14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i >= 1; i--) {
            int nextTime = i + T[i];
            if(nextTime <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[nextTime] + P[i]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        bw.write(dp[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
