package com.codingTest.baekzoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write("" + gcm(a, b));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcm(int a, int b) {
        return a * b / lcd(a, b);
    }

    private static int lcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
