package com.codingTest.programers.level1;

public class 기사단원의_무기 {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int divisors = countDivisors(i);
            if(divisors > limit) answer += power;
            else answer += divisors;
        }

        return answer;
    }

    public int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int number = 5;
        int limit = 3;
        int power = 2;

        기사단원의_무기 res = new 기사단원의_무기();
        System.out.println(res.solution(number, limit, power));
    }
}
