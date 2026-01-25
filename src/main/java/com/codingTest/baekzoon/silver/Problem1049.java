package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1049 - 기타줄
 * ▣ 알고리즘: 그리디
 * ▣ 시간 복잡도: O(M)
 * * [풀이 전략]
 * 1. 모든 브랜드 중 패키지 최저가와 낱개 최저가를 찾는다
 * 2. 세 가지 경우를 비교한다:
 *    - 모두 낱개로 구매
 *    - 패키지 + 낱개 조합
 *    - 패키지만 구매 (남는 줄 포함)
 */
public class Problem1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackage = 1001;
        int minSingle = 1001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int singlePrice = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, packagePrice);
            minSingle = Math.min(minSingle, singlePrice);
        }

        int case1 = N * minSingle;
        int case2 = (N / 6) * minPackage + (N % 6) * minSingle;
        int case3 = ((N + 5) / 6) * minPackage;

        int result = Math.min(case1, Math.min(case2, case3));

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}