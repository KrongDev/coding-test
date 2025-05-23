package com.codingTest.programers.level2;

import java.util.Arrays;

public class 거리두기_확인하기 {
    int[] answer;
    public int[] solution(String[][] places) {
        int len = places.length;
        answer = new int[len];

        for(int i = 0; i < len; i++)
            answer[i] = isBreakRule(places[i]) ? 0 : 1;

        return answer;
    }

    int yLen;
    int xLen;
    boolean[][] visited;

    private boolean isBreakRule(String[] place) {
        yLen = place.length;
        xLen = place[0].length();
        visited = new boolean[yLen][xLen];

        for(int y = 0; y < yLen; y++)
            for(int x = 0; x < xLen; x++)
                if(place[y].charAt(x) != 'X' && place[y].charAt(x) != 'O' && dfs(place, y, x, 0))
                    return true;

        return false;
    }

    int[] yMove = {0, 1, 0};
    int[] xMove = {1, 0, -1};
    private boolean dfs(String[] place, int y, int x, int move) {
        if(move > 2) return false;
        if(place[y].charAt(x) == 'X') return false;
        if(move != 0 && place[y].charAt(x) == 'P')
            return true;

        visited[y][x] = true;
        for(int i = 0; i < 3; i++) {
            int ny = y + yMove[i];
            int nx = x + xMove[i];
            if(!isOver(ny, nx) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if(dfs(place, ny, nx, move + 1))
                    return true;
                visited[ny][nx] = false;
            }
        }
        visited[y][x] = false;
        return false;
    }

    private boolean isOver(int y, int x) {
        return y < 0 || y >= yLen || x < 0 || x >= xLen;
    }

    public static void main(String[] args) {
        거리두기_확인하기 res = new 거리두기_확인하기();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(Arrays.toString(res.solution(places)));
    }

}
