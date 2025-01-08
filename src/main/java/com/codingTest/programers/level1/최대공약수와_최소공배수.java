package com.codingTest.programers.level1;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        if(n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        answer[0] = gcd(n, m);
        answer[1] = n*m/answer[0];

        return answer;
    }

    private int gcd(int n, int m) {
        int r;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 12;
        int m = 39;
        최대공약수와_최소공배수 res = new 최대공약수와_최소공배수();
        System.out.println(Arrays.toString(res.solution(n, m)));
    }
}
