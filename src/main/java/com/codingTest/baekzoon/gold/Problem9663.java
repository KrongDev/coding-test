package com.codingTest.baekzoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9663 {
    // 빈칸: 0, 체스 존재칸: 1
    private static int[][] map;
    private static int N;
    private static int res = 0;

    //N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
    //N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 체스판 및 퀸 숫자
        N = Integer.parseInt(br.readLine());
        // 체스판 제작 y, x
        map = new int[N][N];
        // 체크
        dp(0);
        System.out.println(res);
    }

    private static void dp(int y) {
        if(y == N) {
            res++;
            return;
        }

        for(int x = 0; x < N; x++) {
            // map에 체크
            map[y][x] = 1;
            // 검증 및 다음 depth로 전달
            if(validate(y, x)) {
                dp(y + 1);
            }
            // map 체크 해제
            map[y][x] = 0;
        }
    }

    // 본인의 x, y 좌표가 안전한지 검사
    private static boolean validate(int y, int x) {
        for (int i = y - 1; i >= 0; i--) {
            // 위에 존재할때
            if(map[i][x] == 1) return false;

            //왼쪽 대각선에 존재할때
            int leftX = i-y + x;
            if(leftX > -1 && map[i][leftX] == 1) return false;

            //오른쪽 대각선에 존재할때
            int rightX = y-i + x;
            if(rightX < N && map[i][rightX] == 1) return false;
        }
        return true;
    }
}
