package com.codingTest.leetcode;

import java.util.Arrays;

public class Sudoku_Solver {
    private final int n = 9, m = 10;
    // 가로 체크
    private boolean[][] rowCheck;
    // 세로 체크
    private boolean[][] colCheck;
    // 박스 체크
    private boolean[][] boxCheck;
    // 비어있는 구역 확인
    private int emptyLen;
    private int[][] emptyPoint;

    private void settingPlaceEmptyNums(int place, char[][] board) {
        int row = (place / 3) * 3, col = (place % 3) * 3;
        for (int y = row; y < row + 3; y++) {
            for (int x = col; x < col + 3; x++) {
                if (board[y][x] == '.') {
                    emptyPoint[emptyLen][0] = y;
                    emptyPoint[emptyLen][1] = x;
                    emptyLen++;
                    continue;
                }
                int num = board[y][x] - '0';
                rowCheck[y][num] = true;
                colCheck[x][num] = true;
                boxCheck[place][num] = true;
            }
        }
    }

    private boolean dfs(int index, char[][] board) {
        if (this.emptyLen == index) {
            return true;
        }

        int row = emptyPoint[index][0], col = emptyPoint[index][1];
        int place = (row / 3) * 3 + (col / 3);

        for (int piece = 1; piece < 10; piece++) {
            if(
                    rowCheck[row][piece]
                            || colCheck[col][piece]
                            || boxCheck[place][piece]
            ) continue;
            rowCheck[row][piece] = true;
            colCheck[col][piece] = true;
            boxCheck[place][piece] = true;
            board[row][col] = (char) ('0' + piece);
            if (dfs(index + 1, board)) return true;
            rowCheck[row][piece] = false;
            colCheck[col][piece] = false;
            boxCheck[place][piece] = false;
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        rowCheck = new boolean[n][m];
        colCheck = new boolean[n][m];
        boxCheck = new boolean[n][m];
        emptyLen = 0;
        emptyPoint = new int[n * n][2];

        for (int i = 0; i < 9; i++)
            settingPlaceEmptyNums(i, board);

        dfs(0, board);
    }

    public static void main(String[] args) {
        Sudoku_Solver solver = new Sudoku_Solver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solver.solveSudoku(board);
        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
