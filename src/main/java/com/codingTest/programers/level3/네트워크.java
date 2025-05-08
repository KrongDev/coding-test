package com.codingTest.programers.level3;

public class 네트워크 {
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        boolean[] checked;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            checked = new boolean[n];
            visited[i] = true;
            checked[i] = true;
            boolean res = dfs(checked, i, computers);
            if(!res) {
                answer++;
            }
        }

        return answer;
    }

    private boolean dfs(boolean[] checked, int index, int[][] computers) {
        boolean res = false;
        for(int i = 0; i < computers[index].length; i++) {
            if(computers[index][i] == 0) continue;

            if(checked[i]) continue;
            checked[i] = true;

            if(!visited[i]) {
                visited[i] = true;
                if(dfs(checked, i, computers)) {
                    res = true;
                }
            } else {
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        네트워크 res = new 네트워크();
        int n = 3;
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(res.solution(n, computers));
    }
}
