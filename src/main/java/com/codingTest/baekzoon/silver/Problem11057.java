package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * N은 자릿수를 의미한다.
 * 수는 0부터 시작한다.
 * 10 -> 55 -> 220
 *   5.5    4
 *
 *  0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 *  01, 02, 03, 04, 05, 06, 07, 08, 09
 *  12, 13, 14, 15, 16, 17, 18, 19 ,
 *  23, 24, 25, 26, 27, 28, 29,
 *  34, 35, 36, 37, 38, 39
 *  45, 46, 47, 48, 49,
 *  56, 57, 58, 59
 *  67, 68, 69,
 *  78, 79,
 *  89
 */
public class Problem11057 {
    // 메모리제이션
    private static int[][] map;
    private static int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // map 갯수 초기화
        map = new int[N + 1][10];
        for(int x = 0; x < 10; x++) {
            map[1][x] = 1;
        }
        dp(N, 9);

        int res = 0;
        for(int x = 0; x < 10; x++) {
            res += map[N][x];
        }
        bw.write("" + (res%mod));
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     *
     * @param y 자릿수
     * @param x 뒷 자리의 수
     * @return 갯수
     */
    private static int dp(int y, int x) {
        if(x == 0) map[y][x] = 1;
        if(map[y][x] > 0) return map[y][x];

        map[y][x] = (dp(y - 1, x) + dp(y, x - 1)) % mod;
        return map[y][x];
    }
}
