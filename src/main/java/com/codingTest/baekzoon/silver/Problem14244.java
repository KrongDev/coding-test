package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 0번은 무조껀 leaf
        int leafIndex = N - M;
        for(int i = 1; i <= leafIndex; i++) {
            bw.write(i - 1 + " ");
            bw.write(i + "");
            bw.write("\n");
        }
        for(int i = leafIndex + 1; i < N; i++) {
            bw.write(leafIndex + " ");
            bw.write(i + "");
            bw.write("\n");
        }
        bw.flush();
    }
}
