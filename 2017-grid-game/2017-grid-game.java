class Solution {
    private final int yLen = 2;

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        long topSum = 0;
        for (int i = 0; i < n; i++) {
            topSum += grid[0][i];
        }
        
        long bottomSum = 0;
        long res = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            topSum -= grid[0][i];
            long score = Math.max(topSum, bottomSum);
            res = Math.min(res, score);
            bottomSum += grid[1][i];
        }
        
        return res;
    }
}