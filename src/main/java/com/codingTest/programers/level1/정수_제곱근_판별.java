package com.codingTest.programers.level1;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        long a = (long)Math.sqrt(n);
        return a*a == n ? (long)Math.pow(a+ 1, 2) : -1;
    }

    public static void main(String[] args) {
        int n = 121;
        정수_제곱근_판별 res = new 정수_제곱근_판별();
        System.out.println(res.solution(n));
    }
}
