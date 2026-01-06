package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11726 {

    private static int mod = 10007;
    private static int[] dp;

    private static int factorial(int N) {
        if(N < 3) return N;
        if(dp[N] > 0) return dp[N];
        int res = factorial(N-1) + factorial(N-2);
        dp[N] = res%mod;

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        System.out.println(factorial(N));
    }

}
