class Solution {

    private int mod = 1000000007; 
    public int numberOfWays(String corridor) {
        int sSize = 0;
        char[] crr = corridor.toCharArray(); 
        for(char c: crr) {
            if(c == 'S') {
                sSize++;
            }
        }

        if(sSize < 2 || sSize%2 == 1) return 0;
        if(sSize == 2) return 1;

        long res = 1L;
        int sCount = 0;
        for(int i = 0; i < crr.length; i++) {
            if(crr[i] == 'S') sCount++;
            else continue;
            if(sCount%2 == 1) continue;
            if(sCount == sSize) break;

            int pCount = 0;
            int j = i + 1;
            while(crr[j] == 'P') {
                pCount++;
                j++;
            }
            i = j-1;
            res *= (pCount + 1);
            res %= mod;
        }
        return (int)res;
    }
}