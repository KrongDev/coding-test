package com.codingTest.programers.level1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int move: moves) {
            int moveBoard = move - 1;

            for(int[] row: board) {
                int col = row[moveBoard];
                if(col > 0) {
                    row[moveBoard] = 0;
                    if(bucket.size() == 0) {
                        bucket.push(col);
                        break;
                    }

                    int prevBucket = bucket.peek();
                    if(prevBucket == col) {
                        bucket.pop();
                        answer++;
                    } else {
                        bucket.push(col);
                    }
                    break;
                }
            }
        }

        return answer * 2;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        크레인_인형뽑기_게임 res = new 크레인_인형뽑기_게임();
        System.out.println(res.solution(board, moves));
    }
}
