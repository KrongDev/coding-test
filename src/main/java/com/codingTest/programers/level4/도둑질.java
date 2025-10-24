package com.codingTest.programers.level4;

public class 도둑질 {
    private int dp_solution(int[] money, int len, int start, int end) {

        int[] dp = new int[len];
        dp[start] = money[start];
        dp[start + 1] = Math.max(dp[start], money[start + 1]);

        for(int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        return dp[end - 1];
    }

    public int solution(int[] money) {
        int len = money.length;
        // 첫번째 집 포함
        int a = dp_solution(money, len, 0, len - 1);
        // 첫번째 집 미포함
        int b = dp_solution(money, len, 1, len);

        return Math.max(a, b);
    }
}
