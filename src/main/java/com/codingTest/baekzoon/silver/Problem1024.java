package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1024 - 수열의 합
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1024 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            boolean found = false;

            for (int i = L; i <= 100; i++) {
                long sumOfIndices = (long) i * (i - 1) / 2;

                if ((N - sumOfIndices) % i == 0) {
                    long x = (N - sumOfIndices) / i;

                    if (x >= 0) {
                        for (int j = 0; j < i; j++) {
                            bw.write((x + j) + (j == i - 1 ? "" : " "));
                        }
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                bw.write("-1");
            }

            bw.flush();
            bw.close();
            br.close();
        }
}
