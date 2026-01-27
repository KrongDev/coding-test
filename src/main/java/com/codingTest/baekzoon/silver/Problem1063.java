package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] king = getPoint(st.nextToken());
        int[] stone = getPoint(st.nextToken());
        int moveCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < moveCount; i++) {
            String command = br.readLine();
            int dx = 0, dy = 0;

            switch (command) {
                case "R":  dx = 1;  break;
                case "L":  dx = -1; break;
                case "B":  dy = -1; break;
                case "T":  dy = 1;  break;
                case "RT": dx = 1;  dy = 1;  break;
                case "LT": dx = -1; dy = 1;  break;
                case "RB": dx = 1;  dy = -1; break;
                case "LB": dx = -1; dy = -1; break;
            }

            int nkx = king[0] + dx;
            int nky = king[1] + dy;

            if (isOver(nkx, nky)) continue;

            if (nkx == stone[0] && nky == stone[1]) {
                int nsx = stone[0] + dx;
                int nsy = stone[1] + dy;

                if (isOver(nsx, nsy)) continue;

                stone[0] = nsx;
                stone[1] = nsy;
            }

            king[0] = nkx;
            king[1] = nky;
        }

        System.out.println(makePos(king));
        System.out.println(makePos(stone));
    }

    private static int[] getPoint(String str) {
        int x = str.charAt(0) - 'A';
        int y = str.charAt(1) - '1';
        return new int[]{x, y};
    }

    private static boolean isOver(int x, int y) {
        return x < 0 || x >= 8 || y < 0 || y >= 8;
    }

    private static String makePos(int[] point) {
        return (char) (point[0] + 'A') + "" + (point[1] + 1);
    }
}