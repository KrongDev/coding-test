package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9095 {
    static int res = 0;

    public static void check(int finish, int num) {
        if (num > finish) return;
        if(num == finish) {
            res++;
            return;
        }
        check(finish, num + 1);
        check(finish, num + 2);
        check(finish, num + 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while((t--) > 0) {
            int n = Integer.parseInt(br.readLine());
            check(n, 0);
            sb.append(res).append("\n");
            res = 0;
        }
        System.out.println(sb);
    }
}
