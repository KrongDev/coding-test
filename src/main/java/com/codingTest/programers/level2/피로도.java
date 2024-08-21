package com.codingTest.programers.level2;

public class 피로도 {
    class Solution {
        static boolean[] dp;
        static int ans = 0;

        public static int solution(int k, int[][] dungeons) {

            dp = new boolean[dungeons.length];

            dfs(k, dungeons, 0);
            return ans;
        }

        public static void dfs(int stamina, int[][] dungeons, int count) {
            for(int i = 0; i < dungeons.length; i++) {
                if(!dp[i] && dungeons[i][0] <= stamina) {
                    dp[i] = true;
                    dfs(stamina - dungeons[i][1], dungeons, count + 1);
                    dp[i] = false;
                }
            }
            ans = Math.max(ans, count);
        }
    }
}
