package com.codingTest.programers.level1;

public class 소수_찾기 {
    public int solution(int n) {
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!arr[i]) {
                int j = 2;
                while(i * j <= n) {
                    arr[i*j] = true;
                    j++;
                }
            }
        }

        int answer = 0;
        for(boolean b : arr) {
            if(!b) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        소수_찾기 res = new 소수_찾기();
        System.out.println(res.solution(n));
    }
}
