package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.*;

/**
 * ▣ 문제: 백준: 1051 - 숫자 정사각형
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int maxLen = Math.min(N, M);

        boolean found = false;
        int result = 1;

        for (int k = maxLen; k > 1; k--) {
            for (int i = 0; i <= N - k; i++) {
                for (int j = 0; j <= M - k; j++) {
                    int target = map[i][j];

                    if (map[i][j + k - 1] == target &&
                            map[i + k - 1][j] == target &&
                            map[i + k - 1][j + k - 1] == target) {
                        result = k;
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (found) break;
        }

        bw.write(String.valueOf(result * result));
        bw.flush();
        bw.close();
        br.close();
    }
}
