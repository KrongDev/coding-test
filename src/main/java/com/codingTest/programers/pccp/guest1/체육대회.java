package com.codingTest.programers.pccp.guest1;

public class 체육대회 {
    int answer = 0;
    boolean[] visited;

    public int solution(int[][] ability) {
        int N = ability.length;
        int M = ability[0].length;
        visited = new boolean[N];
        dfs(0, 0, ability, M);
        return answer;
    }

    public void dfs(int depth, int sum, int[][] ability, int M) {
        if (depth == M) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + ability[i][depth], ability, M);
                visited[i] = false;
            }
        }
    }
}
