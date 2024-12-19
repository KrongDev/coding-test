package com.codingTest.programers.pccp.guest1;

public class 이웃한_칸 {
    private String[][] board;

    public int solution(String[][] board, int h, int w) {
        this.board = board;
        String color = board[h][w];

        int answer = 0;
        if(checkUp(h, w, color)) answer++;
        if(checkDown(h, w, color)) answer++;
        if(checkLeft(h, w, color)) answer++;
        if(checkRight(h, w, color)) answer++;
        return answer;
    }

    private boolean checkUp(int y, int x, String color) {
        if(y == 0) return false;
        return color.equals(board[y - 1][x]);
    }

    private boolean checkDown(int y, int x, String color) {
        if(y == board.length - 1) return false;
        return color.equals(board[y + 1][x]);
    }

    private boolean checkLeft(int y, int x, String color) {
        if(x == 0) return false;
        return color.equals(board[y][x - 1]);
    }

    private boolean checkRight(int y, int x, String color) {
        if(x == board[0].length - 1) return false;
        return color.equals(board[y][x + 1]);
    }

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        이웃한_칸 res = new 이웃한_칸();
        System.out.println(res.solution(board, h, w));
    }
}
