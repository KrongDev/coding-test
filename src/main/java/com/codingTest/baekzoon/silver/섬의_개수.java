package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class 섬의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            if(line.equals("0 0")) break;
            st = new StringTokenizer(line);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int[][] map = genMap(w, h, br, st);

            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == 1) {
                        map[i][j]++;
                        dfs(map, i, j, h, w);
                    }
                }
            }
            int answer = getAnswer(map);
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] genMap(int w, int h, BufferedReader br, StringTokenizer st) throws IOException {
        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }

    private static final int[] yMove = {-1, 0, 1, 0};
    private static final int[] xMove = {0, -1, 0, 1};
    private static final int[][] dx = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    private static void dfs(int[][] map, int y, int x, int h, int w) {
        for(int i = 0; i < 4; i++) {
            int newY = y + yMove[i];
            int newX = x + xMove[i];
            if(isOver(newY, newX, h, w)) continue;
            if(map[newY][newX] != 1) continue;

            map[newY][newX] = map[y][x] + 1;
            dfs(map, newY, newX, h, w);
        }

        for(int i = 0; i < 4; i++) {
            int newY = y + dx[i][0];
            int newX = x + dx[i][1];
            if(isOver(newY, newX, h, w)) continue;
            if(map[newY][newX] != 1) continue;

            map[newY][newX] = map[y][x] + 1;
            dfs(map, newY, newX, h, w);
        }
    }

    private static int getAnswer(int[][] map) {
        int answer = 0;
        for(int[] line: map) {
            for(int block: line) {
                if(block == 2) answer++;
            }
        }
        return answer;
    }

    private static boolean isOver(int y, int x, int h, int w) {
        return y < 0 || x < 0 || y >= h || x >= w;
    }
}
