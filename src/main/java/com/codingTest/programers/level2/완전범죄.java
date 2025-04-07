package com.codingTest.programers.level2;

import java.util.Arrays;


public class 완전범죄 {
    int[][] dp;

    public int solution(int[][] info, int n, int m) {
        dp = new int[info.length + 1][m];

        for (int i = 1; i <= info.length; i++) {
            Arrays.fill(dp[i], n);
        }

        for (int i = 1; i <= info.length; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);

                if (j + b < m)
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
            }
        }

        int answer = n;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[info.length][j]);
        }

        return answer >= n ? -1 : answer;
    }

    public static void main(String[] args) {
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4, m = 4;
        완전범죄 res = new 완전범죄();
        System.out.println(res.solution(info, n, m));
    }
}
