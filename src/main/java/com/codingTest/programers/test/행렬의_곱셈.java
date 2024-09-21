package com.codingTest.programers.test;

public class 행렬의_곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int arr1YLen = arr1.length;
        int arr1XLen = arr1[0].length;
        int arr2XLen = arr2[0].length;

        int[][] answer = new int[arr1YLen][arr2XLen];

        for(int i = 0; i < arr1YLen; i++) {
            for(int j = 0; j < arr2XLen; j++) {
                for(int k = 0; k < arr1XLen; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
