class Solution {

    
    private long[] dp;

    public long getDescentPeriods(int[] prices) {
        int N = prices.length;
        long res = 0;
        dp = new long[N + 1];

        for(int i = 0; i < prices.length; i++) {
            if(i + 1 == prices.length || prices[i] - 1 != prices[i + 1]) {
                res++;
                continue;
            }

            int j = i;
            while(j + 1 < prices.length && prices[j] - 1 == prices[j + 1]) {
                j++;
            }
            res += getPeriodsCount(j - i + 1);
            i = j;
        }

        return res;
    }


    private long getPeriodsCount(int size) {
        if(size == 1) return 1;
        if(dp[size] != 0) return dp[size];
        dp[size] = size + getPeriodsCount(size - 1);
        return dp[size];
    }
}