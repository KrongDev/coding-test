package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++) {
                int num = Integer.parseInt(st.nextToken());
                map[y][x] = map[y][x-1] + num;
            }
        }

        StringBuilder sb = new StringBuilder();
        while((M--) > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());


            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);
            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);

            int res=0;
            for(int i = minY; i <= maxY; i++) {
                res+=map[i][maxX] - map[i][minX- 1];
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
