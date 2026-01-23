package com.codingTest.baekzoon.bronze;

import java.io.*;

/**
 * ▣ 문제: 백준: 8958 - OX퀴즈
 * ▣ 알고리즘: 구현
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */


public class Problem8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String str;
        while((T--) > 0) {
            str = br.readLine();
            int answer = 0;
            int current = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'O') {
                    current++;
                    answer += current;
                } else {
                    current = 0;
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
