package com.codingTest.programers.level2;

import java.util.*;

public class 석유_시추 {
    // N=깊이, M=넓이
    private int N, M;
    // 시추관 위치별 석유량
    private int[] map;

    public int solution(int[][] land) {
        // 깊이
        N = land.length;
        // 넓이
        M = land[0].length;
        map = new int[M];

        // 모든 넓이를 찔러본다.
        boolean[][] visited = new boolean[N][M];
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if(land[y][x] == 1 && !visited[y][x])
                    bfs(land, visited, y, x);
            }
        }

        int answer = 0;
        for(int count: map) {
            answer = Math.max(answer, count);
        }
        return answer;
    }

    private void bfs(int[][] land, boolean[][] visited, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        // 상, 하, 좌, 우 이동
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int count = 1;
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            set.add(cur[1]);

            for(int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(!checkRange(ny, nx)) continue;
                if(land[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }

        for(int i: set) {
            map[i] += count;
        }
    }

    private boolean checkRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }



    public static void main(String[] args) {
        석유_시추 res = new 석유_시추();
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(res.solution(land));
    }
}
