package com.codingTest.programers.level1;

import java.util.Arrays;

public class 과일_장수 {

    public int solution(int k, int m, int[] score) {
        int len = score.length;
        Arrays.sort(score);

        int answer = 0;
        for(int i = len; i >= m; i-=m) {
            answer += score[i - m] * m;
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = new int[] {1, 2, 3, 1, 2, 3, 1};
        과일_장수 res = new 과일_장수();
        System.out.println(res.solution(k, m, score));
    }
}
