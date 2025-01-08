package com.codingTest.programers.level1;

public class 문제_3진법_뒤집기 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append(n % 3);
            n /= 3;
        }

        return Integer.parseInt(sb.toString(), 3);
    }

    public static void main(String[] args) {
        int n = 45;
        문제_3진법_뒤집기 res = new 문제_3진법_뒤집기();
        System.out.println(res.solution(n));
    }
}
