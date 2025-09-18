package com.codingTest.programers.level2;

public class NQueen {
    static class Solution {
        int[] map;
        boolean[] visited;
        int N;
        int answer = 0;

        public int solution(int n) {
            this.map = new int[n];
            this.visited = new boolean[n];
            this.N = n;

            dfs(0);
            return answer;
        }

        public void dfs(int y) {
            if(y == N) {
                answer++;
                return;
            }

            for(int i = 0; i < N; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                map[y] = i;
                if(isValid(i, y)) dfs(y + 1);
                visited[i] = false;
            }
        }

        private boolean isValid(int x, int y) {
            for(int i = 1; i <= y; i++) {
                if(map[y - i] == x) return false;
                if(x - i > -1 && map[y - i] == x - i) return false;
                if(x + i < N && map[y - i] == x + i) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(4);
        System.out.println(solution.answer);
    }
}
