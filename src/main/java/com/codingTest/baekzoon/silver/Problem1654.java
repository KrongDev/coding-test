package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long max = 0;             // 최대 길이
        int[] lens = new int[N];
        for(int i = 0; i < N; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            if(lens[i] > max) max = lens[i];
        }

        //  mid가 0일 상황 방지
        max++;

        long min = 0;                        // 최소 길이
        while(min < max) {
            long mid = (min + max) / 2;      // 나눈 길이

            long count = 0;
            for(int i = 0; i < N; i++) {
                count += (lens[i]/mid);
            }

            if(count < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min - 1));
        bw.flush();
        bw.close();
    }
}
