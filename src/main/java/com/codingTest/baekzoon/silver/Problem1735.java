package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long aChild = Long.parseLong(st.nextToken());
        long aParent = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long bChild = Long.parseLong(st.nextToken());
        long bParent = Long.parseLong(st.nextToken());

        long gcm = gcm(aParent, bParent);

        aChild *= gcm/aParent;
        bChild *= gcm/bParent;

        long resChild = (aChild + bChild);
        long lcd = lcd(resChild, gcm);

        // 기약분수로 제출
        bw.write( (resChild / lcd) + " " + (gcm / lcd));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long lcd(long a, long b) {
        while(b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long gcm(long a, long b) {
        return a * b / lcd(a, b);
    }
}
