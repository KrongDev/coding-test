class Solution {
    private final int mod = 1000000007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        if(n == 0) return 0;
        if(n == 1) return 1;

        long res = 1;
        int complateZero = complexity[0];
        for(int i = 1; i < n; i++) {
            if(complateZero >= complexity[i]) return 0;         
            res = (res * i)%mod;
        }
        return (int) res;
    }
}