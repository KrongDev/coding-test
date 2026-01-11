package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 2293 - 동전 1
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N*k)
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전 가치
        int[] coin = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];
        // 0원을 만드는 방법
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // coins
        for(int i = 1; i <= n; i++) {
            // j원을 만드는 갯수
            for(int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                // j원을 만드는 방법은 dp[j]에 있다.
                // + dp[j - coin[i] 는 n을 만드는데 coin[i]를 합쳤을 때 만들 수 있는 가짓수이다.
                // 여기서 coin[i]은 여러번 사용할 수 있다.
                int count = 1;
                while(coin[i] * count <= j) {
                    dp[i][j] += dp[i - 1][j - (coin[i]*count)];
                    count++;
                }
            }
        }

        bw.write(dp[n][k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
