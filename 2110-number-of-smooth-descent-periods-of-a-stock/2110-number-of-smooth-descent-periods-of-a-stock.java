class Solution {

    public long getDescentPeriods(int[] prices) {
        int N = prices.length;
        long res = 1L;
        int cumulative = 1;

        for(int i = 1; i < N; i++) {
            if(prices[i - 1] - prices[i] == 1) cumulative++;
            else cumulative = 1;
            res += cumulative;
        }

        return res;
    }
}