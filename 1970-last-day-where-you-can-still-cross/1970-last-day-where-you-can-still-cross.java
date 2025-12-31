class Solution {
    
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1, r = cells.length;
        int res = 0;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(bfs(row, col, cells, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private boolean bfs(int row, int col, int[][] cells, int day) {
        boolean[][] grid = new boolean[row + 1][col + 1];
        for(int i = 0; i < day; i++) {
            grid[cells[i][0]][cells[i][1]] = true;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row + 1][col + 1];

        for(int x = 1; x <= col; x++) {
            if(!grid[1][x]) {
                visited[1][x] = true;
                queue.offer(new int[] {1,x});
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            if(y == row) return true;
            for(int[] d: dirs) {
                int ny = y + d[0];
                int nx = x + d[1];

                if(ny > 0 && ny <= row && nx > 0 && nx <= col
                && !visited[ny][nx] && !grid[ny][nx]) {
                   visited[ny][nx] = true;
                   queue.offer(new int[]{ny, nx}); 
                }
            }
        }
        return false;
    }
}