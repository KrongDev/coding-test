package com.codingTest.leetcode;

public class Valid_Sudoku {
    private final int n = 9, m = 10;
    private boolean[][] rowChk = new boolean[9][10];
    private boolean[][] colChk = new boolean[9][10];
    private boolean[][] boxChk = new boolean[9][10];

    private boolean isValidPlace(int row, int col, int num) {
        int placePoint = (row/3) * 3 + (col/3);
        if(boxChk[placePoint][num]) return false;
        boxChk[placePoint][num] = true;
        return true;
    }

    private boolean isValidLine(int row, int col, int num) {
        if(rowChk[row][num] || colChk[col][num]) return false;
        rowChk[row][num] = true;
        colChk[col][num] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        rowChk = new boolean[9][10];
        colChk = new boolean[9][10];
        boxChk = new boolean[9][10];
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') continue;
                int num = board[row][col] - '0';

                if(!isValidPlace(row, col, num)) return false;
                if(!isValidLine(row, col, num)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Sudoku sudoku = new Valid_Sudoku();
        char[][] board = {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(sudoku.isValidSudoku(board));
    }
}
