package com.codingTest.programers.level1;

import java.util.Stack;

public class 다트_게임 {
    public int solution(String dartResult) {
        int answer = 0;

        int dartI = 0;
        int prev = 0;
        for(int i = 0; i < 3; i++) {
            int endIndex = searchDigitEndIndex(dartResult, dartI);
            int score = Integer.parseInt(dartResult.substring(dartI, endIndex));
            dartI = endIndex;
            char area = dartResult.charAt(dartI++);
            switch (area) {
                case 'D':
                    score = (int)Math.pow(score, 2);
                    break;
                case 'T':
                    score = (int)Math.pow(score, 3);
                    break;
            }
            if(dartI == dartResult.length()) {
                answer += score;
                break;
            }
            char option = dartResult.charAt(dartI++);
            if(option == '*') {
                answer += prev;
                score = score * 2;

            } else if(option == '#') {
                score = score * -1;
            } else {
                dartI--;
            }
            answer += score;
            prev = score;
        }

        return answer;
    }

    private int searchDigitEndIndex(String dartResult, int start) {
        while (true) {
            if(Character.isDigit(dartResult.charAt(start))) {
                start++;
                continue;
            }
            return start;
        }
    }

    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        다트_게임 res = new 다트_게임();
        System.out.println(res.solution(dartResult));
    }
}
