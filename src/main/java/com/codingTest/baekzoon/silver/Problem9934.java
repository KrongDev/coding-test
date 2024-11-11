package com.codingTest.baekzoon.silver;

import java.io.*;

public class Problem9934 {

    static StringBuilder[] sbs;
    static String[] strr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        strr = br.readLine().split(" ");
        sbs = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            sbs[i] = new StringBuilder();
        }

        solve(0, strr.length - 1, 0);

        for (int i = 0; i < N; i++) {
            bw.write(sbs[i].toString() + "\n");
        }


        bw.flush();
    }

    public static void solve( int start, int end, int level) {
        if(level == N) return;
        int mid = (start + end) / 2;
        sbs[level].append(strr[mid]).append(" ");

        solve(start, mid - 1, level + 1);
        solve(mid + 1, end, level + 1);
    }
}
