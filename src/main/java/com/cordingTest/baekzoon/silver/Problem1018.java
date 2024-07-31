package com.cordingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Problem1018 {

    public static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // map데이터 추가
        map = new String[N][M];
        for (int y = 0; y < N; y++) {
            String[] str = br.readLine().split("");
            System.arraycopy(str, 0, map[y], 0, M);
        }

        int endY = N - 8;
        int endX = M - 8;
        int res = -1;
        // 8 * 8 rewrite 검사
        br:
        for (int y = 0; y <= endY; y++) {
            for (int x = 0; x <= endX; x++) {
                int rewriteCount = checkRewriteMap(y, x);
                if (res == -1 || res > rewriteCount) res = rewriteCount;
                if (res == 0) break br;
            }
        }
        System.out.println(res);
    }

    public static int checkRewriteMap(int startY, int startX) {
        int endY = startY + 8;
        int endX = startX + 8;
        int white = 0;
        int black = 0;
        // row 문자열 배열(配列) 확인용
        boolean isJJackRow;
        for (int y = startY; y < endY; y++) {
            isJJackRow = y % 2 == 0;
            String point = isJJackRow ? "W" : "B";
            String whiteSpace = isJJackRow ? "B" : "W";
            for (int x = startX; x < endX; x++) {
                boolean isJJackCol = x % 2 == 0;
                String col = map[y][x];
                if (isJJackCol) {
                    if (point.equals(col)) black++;
                    else white++;
                } else {
                    if (whiteSpace.equals(col)) black++;
                    else white++;
                }
            }
        }
        return Math.min(white, black);
    }

}
