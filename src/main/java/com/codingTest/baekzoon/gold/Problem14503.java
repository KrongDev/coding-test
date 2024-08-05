package com.codingTest.baekzoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 보는 방향 - 북, 동, 남, 서
        int[] dY = {-1, 0, 1, 0};
        int[] dX = {0, 1, 0, -1};
        int[] backY = {1, 0, -1, 0};
        int[] backX = {0, -1, 0, 1};

        // Map Y
        int N = Integer.parseInt(st.nextToken());
        // Map X
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 초기 위치 y
        int r = Integer.parseInt(st.nextToken());
        //초기 위치 x
        int c = Integer.parseInt(st.nextToken());
        // 초기 바라보는 방향 0: 북, 1: 동, 2: 남, 3: 서
        int d = Integer.parseInt(st.nextToken());

        // 1 = 벽, 0 = 청소안된 빈칸, -1 = 청소 된 칸
        int[][] map = new int[N][M];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                int point = Integer.parseInt(st.nextToken());
                map[y][x] = point;
            }
        }
        int res = 0;
        while (true) {
            // 현재 위치한 곳이 청소가 안된경우
            if(map[r][c] == 0) {
                map[r][c]--;
                res++;
            }
            // 맡붙은 4면중 청소가 안된 부분 체크 90도 돌려서 앞에 있는 칸 체크 -> 4번 반복
            boolean searchIsOk = false;
            for(int i = 1; i <= 4; i++) {
                int cloneD = (d - i + 4)%4;
                int checkR = r + dY[cloneD];
                int checkC = c + dX[cloneD];
                if (map[checkR][checkC] == 0) {
                    d = cloneD;
                    r += dY[d];
                    c += dX[d];
                    searchIsOk = true;
                    break;
                }
            }
            if(searchIsOk) continue;
            // 없으면 뒤로 한칸 뒤에 벽이면 종료
            if(map[r + backY[d]][c + backX[d]] != 1) {
                r += backY[d];
                c += backX[d];
            } else {
                break;
            }
        }

        System.out.println(res);
    }
}
