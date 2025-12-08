class Solution {
    public int mySqrt(int x) {
        if(x == 0) return x;
        
        int l = 0, r = x;
        int mid = 0;
        int ans = 1;
        while(l <= r) {
            mid = l + (r - l)/2;

           long square = (long)mid * mid;
            if(square == x) return mid;

            if(square > x) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }

        return ans;
    }
}