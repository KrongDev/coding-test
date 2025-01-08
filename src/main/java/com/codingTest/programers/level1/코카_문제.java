package com.codingTest.programers.level1;

public class 코카_문제 {

    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            answer+= n/a * b;
            n = n%a + n/a * b;
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;
        코카_문제 res = new 코카_문제();
        System.out.println(res.solution(a, b, n));
    }
}
