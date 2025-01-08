package com.codingTest.programers.level1;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int i = 0; i < d.length; i++) {
            budget -= d[i];
            if(budget < 0) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] arg) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        예산 res = new 예산();
        System.out.println(res.solution(d, budget));
    }
}
