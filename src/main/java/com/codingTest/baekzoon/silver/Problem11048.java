package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11048 {
    private static int N, M;
    private static int[][] map, dp;

    private static int[] moveX = {0, 1, 1}, moveY = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map의 시작점은 (1, 1)
        map = new int[N + 1][M + 1];
        // 누적 사탕 수
        dp = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동은 아래, 오른쪽, 아래 오른쪽 대각선으로 이동가능
//        dfs(1, 1, 0);
        // DP 시간복잡도 O(n*m)
        for(int y = 1; y <= N; y++) {
            for(int x = 1; x <= M; x++) {
                int prevMax = Math.max(dp[y - 1][x], dp[y][x - 1]);
                prevMax = Math.max(prevMax, dp[y - 1][x - 1]);
                dp[y][x] = prevMax + map[y][x];
            }
        }

        // dp에 저장한 (N,M) 좌표 값만 출력 최종 시간복잡도 O(nlogn)
        bw.write(dp[N][M] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

//    private static void dfs(int y, int x, int res) {
//        if(isOverMap(y, x)) return;
//
//        res += map[y][x];
//        if(dp[y][x] > res) return;
//
//        dp[y][x] = res;
//
//
//        for(int i = 0; i < 3; i++) {
//            dfs(y + moveY[i], x + moveX[i], res);
//        }
//    }
//
//    private static boolean isOverMap(int y, int x) {
//        if(y < 0 || x < 0) return true;
//        if(y > N || x > M) return true;
//        return false;
//    }
}
