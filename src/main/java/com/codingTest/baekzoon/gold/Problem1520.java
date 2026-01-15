package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1520 - 내리막 길
 * ▣ 알고리즘: dfs + 메모이제이션
 * ▣ 시간 복잡도: O(M*N)
 * * [풀이 전략]
 * 1. dfs로 최종 도달 경로에 도달 후 도달가능 경로 수를 측정
 * 2. Timeout당하지 않기 위해서는 Map의 한번 방문한 곳은 재방문 하지 않는 것이 필수사항
 */
public class Problem1520 {
    private static int m;
    private static int n;

    private static int[][] map;
    private static int[][] dp;
    private static boolean[][] visited;

    private static final int[] my = {-1, 0, 1, 0};
    private static final int[] mx = {0, 1, 0, -1};

    private static int dfs(int y, int x) {
        if(dp[y][x] != 0 || visited[y][x]) return dp[y][x];

        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int ny = y + my[i];
            int nx = x + mx[i];
            if (ny < 1 || ny > m || nx < 1 || nx > n) continue;
            if(map[y][x] > map[ny][nx]) {
                dp[y][x] += dfs(ny, nx);
            }
        }

        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];
        visited = new boolean[m + 1][n + 1];
        dp[m][n] = 1;

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dfs(1, 1);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
