package com.codingTest.programers.level1;

import java.util.Arrays;

public class 행렬의_덧셈 {
    public int[][] solution(int[][] arr1, int[][]arr2) {
        int yLen = arr1.length;
        int xLen = arr1[0].length;
        int[][] answer = new int[yLen][xLen];
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};
        행렬의_덧셈 res = new 행렬의_덧셈();
        System.out.println(Arrays.toString(res.solution(arr1, arr2)));
    }
}
