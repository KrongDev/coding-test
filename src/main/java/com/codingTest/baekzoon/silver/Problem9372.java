package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.*;

public class Problem9372 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                br.readLine();
            }
            sb.append(n - 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
