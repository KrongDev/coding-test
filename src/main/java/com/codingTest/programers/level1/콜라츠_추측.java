package com.codingTest.programers.level1;

import java.math.BigInteger;

public class 콜라츠_추측 {
    public int solution(int num) {
        int answer = 0;
        long check = num;
        while(check != 1) {
            if(answer == 500) return -1;
            if(check % 2 == 0) {
                check = check / 2;
            } else {
                check = check * 3 + 1;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        콜라츠_추측 res = new 콜라츠_추측();
        System.out.println(res.solution(626331));
    }
}
