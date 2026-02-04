package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1064 - 평행사변형
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double x3 = Double.parseDouble(st.nextToken());
        double y3 = Double.parseDouble(st.nextToken());

        if ((x2 - x1) * (y3 - y2) == (y2 - y1) * (x3 - x2)) {
            bw.write("-1.0\n");
        } else {
            double d1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            double d2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
            double d3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

            double len1 = 2 * (d1 + d2);
            double len2 = 2 * (d1 + d3);
            double len3 = 2 * (d2 + d3);

            double maxLen = Math.max(len1, Math.max(len2, len3));
            double minLen = Math.min(len1, Math.min(len2, len3));

            bw.write((maxLen - minLen) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
