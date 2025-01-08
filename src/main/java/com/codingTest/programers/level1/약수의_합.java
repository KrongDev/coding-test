package com.codingTest.programers.level1;

public class 약수의_합 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i == 0) {
                answer += i;
                if(n/i != i) {
                    answer += n/i;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 12;
        약수의_합 res = new 약수의_합();
        System.out.println(res.solution(n));
    }
}
