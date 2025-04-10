package com.codingTest.programers.level2;

public class 비밀_코드_해독 {

    int n;
    int[][] q;
    int[] ans;

    int[] arr = new int[5];
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;

        dfs(1, 0);

        return answer;
    }

    void dfs(int cur, int cnt) {
        if (cnt == 5) {
            if(check()) answer++;
            return;
        }

        for (int i=cur; i<=n; i++) {
            arr[cnt] = i;
            dfs(i+1, cnt+1);
        }
    }


    boolean check() {
        for (int i=0; i<q.length; i++) {
            int cnt = 0;
            for (int j=0; j<5; j++) {
                for (int num : arr) {
                    if (num == q[i][j]) cnt++;
                }
            }
            if (cnt != ans[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};

        비밀_코드_해독 res = new 비밀_코드_해독();
        System.out.println(res.solution(n, q, ans));
    }
}
