class Solution {
    /**
        1 = 1
        2 = 11, 2
        3 = 12, 111, 21
        4 = 112, 22, 121, 1111, 211
     */
    int[] dp;
    private int factorial(int n) {
        if(dp[n] > 0) return dp[n];
        dp[n] = factorial(n - 2) + factorial(n - 1);
        return dp[n];
    }

    public int climbStairs(int n) {
        if(n < 2) return n;
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        return factorial(n);
    }
}