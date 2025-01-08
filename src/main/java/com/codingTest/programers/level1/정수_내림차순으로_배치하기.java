package com.codingTest.programers.level1;

public class 정수_내림차순으로_배치하기 {

    public long solution(long n) {
        int[] arr = new int[10];
        while(n != 0) {
            arr[(int) (n%10)]++;
            n /= 10;
        }
        long answer = 0;
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < arr[i]; j++) {
                answer *= 10;
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        long n = 118372;
        정수_내림차순으로_배치하기 res = new 정수_내림차순으로_배치하기();
        System.out.println(res.solution(n));
    }
}
