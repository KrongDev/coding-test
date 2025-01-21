package com.codingTest.programers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {

    private int n;
    private int m;

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);

                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (ch == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int a = bfs(maps, start, lever);
        int b = bfs(maps, lever, end);

        if (a == -1 || b == -1) {
            return -1;
        }

        return a + b;
    }

    private int bfs(String[] maps, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        int y = start[0];
        int x = start[1];

        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            y = coordinate[0];
            x = coordinate[1];
            if(y == end[0] && x == end[1]) {
                return visited[y][x];
            }

            for(int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if(!isSafe(newY, newX) || maps[newY].charAt(newX) == 'X' || visited[newY][newX] > 0) continue;
                visited[newY][newX] = visited[y][x] + 1;
                queue.add(new int[]{newY, newX});
            }
        }

        return -1;
    }

    private boolean isSafe(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    public static void main(String[] args) {
        미로_탈출 res = new 미로_탈출();
        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(res.solution(maps));
    }
}
