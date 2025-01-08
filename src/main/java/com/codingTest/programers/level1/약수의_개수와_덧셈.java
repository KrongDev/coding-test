package com.codingTest.programers.level1;

public class 약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            if(i % Math.sqrt(i) == 0) answer -= i;
            else answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int left = 24;
        int right = 27;
        약수의_개수와_덧셈 res = new 약수의_개수와_덧셈();
        System.out.println(res.solution(left, right));
    }
}
