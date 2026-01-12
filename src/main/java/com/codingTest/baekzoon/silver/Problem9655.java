package com.codingTest.baekzoon.silver;

import java.io.*;

/**
 * ▣ 문제: 백준: 9655 - 돌 게임
 * ▣ 알고리즘: 구현
 * ▣ 시간 복잡도: O(1)
 * * [풀이 전략]
 * 1. 수열 관점으로 분석하면 DP를 적용할 수는 있다.
 * 2. 하지만 돌을 1 or 3개씩 가져갈 수 있다는 조건이 명확하여 O(1)로 풀이가 가능하다.
 */
public class Problem9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String answer = N%2==0 ? "CY" : "SK";
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
