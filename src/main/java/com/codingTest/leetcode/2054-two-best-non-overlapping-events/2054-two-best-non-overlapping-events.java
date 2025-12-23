class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[1]-b[1]);
        final int N = events.length;
        int[] timeMax = new int[N];
        timeMax[0] = events[0][2];

        for(int i = 1; i < N; i++) {
            timeMax[i] = Math.max(timeMax[i-1], events[i][2]); 
        }

        int res = 0;
        for(int i = N - 1; i > -1; i--) {
            int start = events[i][0];
            int value = events[i][2];

            int idx = binarySearch(events, start);
            if(idx == -1) {
                res = Math.max(res, value);    
            } else {
                res = Math.max(res, value + timeMax[idx]);
            }
        }

        return res;
    }

    private int binarySearch(int[][] events, int point) {
        int l = 0, r = events.length - 1, mid;
        int res = -1;
        while(l <= r) {
            mid =  l + (r-l)/2;
            if(events[mid][1] < point) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}