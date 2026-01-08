package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 12865 - 평범한 배낭
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N*K)
 * * [풀이 전략]
 * 1. 1 <= N <= 100
 * 2. 1 <= K <= 100000
 * 3. O(N^2) 이었을 때 10000 밖에 안된다.
 * 4. 즉, 모든 경우의 수를 체크한다. = 시간초과 오류 발생
 * 5. DP 사용 무게별 가치를 펼친다.
 * 6. 입고 가능 무게(J)에서 현재 무게를 뺀 가치와 이전 가치를 비교하여 현재 무게에 대한 최대 가치를 기록한다.
 * 7  DP[N][K}에는 최대 가치값이 몰리게 된다.
 * 즉, 현재 무게에 대한 최대 가치를 매순간 무게1부터 기록하게 된다.
 */
public class Problem12865 {

//    private static int[] visited;
//    private static int dfs(int index, int num, int weight, int K, int[][] score) {
//        if(weight + score[index][0] > K) return num;
//        int nowWeight = weight + score[index][0];
//        int nowNum = num + score[index][1];
//        if(nowWeight == K) return nowNum;
//
//        int res = nowNum;
//        for(int i = 0; i < score.length; i++) {
//            if(visited[i] == 1) continue;
//            visited[i] = 1;
//            res = Math.max(res, dfs(i, nowNum, nowWeight, K, score));
//            visited[i] = 0;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        int[][] score = new int[N][2];
//
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            score[i][0] = Integer.parseInt(st.nextToken());
//            score[i][1] = Integer.parseInt(st.nextToken());
//        }
//        visited = new int[N];
//
//        int res = 0;
//        for(int i = 0; i < score.length; i++) {
//            visited[i] = 1;
//            res = Math.max(res, dfs(i, 0, 0, K, score));
//            visited[i] = 0;
//        }
//
//        bw.write(res + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] score = new int[N + 1][2];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= score[i][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - score[i][0]] + score[i][1]);
                }
            }
        }
        bw.write(dp[N][K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
