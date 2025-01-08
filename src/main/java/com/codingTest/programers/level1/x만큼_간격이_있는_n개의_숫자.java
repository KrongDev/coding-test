package com.codingTest.programers.level1;

import java.util.Arrays;

public class x만큼_간격이_있는_n개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        x만큼_간격이_있는_n개의_숫자 res = new x만큼_간격이_있는_n개의_숫자();
        System.out.println(Arrays.toString(res.solution(x, n)));
    }
}
