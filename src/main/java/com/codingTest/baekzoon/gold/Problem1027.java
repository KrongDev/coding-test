package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.StringTokenizer;
/**
 * ▣ 문제: 백준: 1027 - 고층 건물
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] heights = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(st.nextToken());
        }

        int maxVisible = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            double lastSlope = 0;

            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (heights[i] - heights[j]) / (i - j);
                if (j == i - 1 || slope < lastSlope) {
                    count++;
                    lastSlope = slope;
                }
            }

            for (int j = i + 1; j < N; j++) {
                double slope = (double) (heights[j] - heights[i]) / (j - i);
                if (j == i + 1 || slope > lastSlope) {
                    count++;
                    lastSlope = slope;
                }
            }

            maxVisible = Math.max(maxVisible, count);
        }

        bw.write(String.valueOf(maxVisible));
        bw.flush();
        bw.close();
        br.close();
    }
}
