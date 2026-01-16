package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ▣ 문제: : 백준 - 전깃줄 2565
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1. 안정 구간을 지정하여 해당 구간 내 제거 최소 수를 지정
 * 2. 첫번째 라인을 지정하여 우상향/우하향을 분리
 * 3. 두 그룹 중 적은 수 제거
 */
public class Problem2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] wire = new int[N][2];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, ((o1, o2) -> o1[0] - o2[0]));

        int max = 0;
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(wire[j][1] < wire[i][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        bw.write(N-max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
