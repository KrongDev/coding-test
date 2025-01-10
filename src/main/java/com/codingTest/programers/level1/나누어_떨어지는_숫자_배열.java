package com.codingTest.programers.level1;

import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer =  Arrays.stream(arr).filter(x -> x % divisor == 0)
                .sorted()
                .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        나누어_떨어지는_숫자_배열 res = new 나누어_떨어지는_숫자_배열();
        int[] arr = {2, 36, 1, 3};
        int divisor = 1;
        System.out.println(Arrays.toString(res.solution(arr, divisor)));
    }
}
