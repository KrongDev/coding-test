package com.codingTest.programers.level1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int[] answer = new int[arr.length - 1];
        int minIndex = getMinIndex(arr);
        for(int i = 0; i < arr.length - 1; i++) {
            if(minIndex <= i) answer[i] = arr[i + 1];
            else answer[i] = arr[i];
        }
        return answer;
    }

    private int getMinIndex(int[] arr) {
        int min = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[min] > arr[i]) min = i;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 11, 21};
        제일_작은_수_제거하기 res = new 제일_작은_수_제거하기();
        System.out.println(Arrays.toString(res.solution(arr)));
    }
}
