package com.codingTest.programers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    private final int[] yMove = {-1, 0, 1, 0};
    private final int[] xMove = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        int yLen = maps.length;
        int xLen = maps[0].length;
        // 1 X 1의 방인경우
        if(yLen == 1 && xLen == 1){
            return 0;
        }
        // 경로 누적합
        int[][] check = new int[yLen][xLen];
        // 0: y, 1: x
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        // 최단 경로를 찾기 때문에 BFS로 구현
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int y = cur[0] + yMove[i];
                int x = cur[1] + xMove[i];
                // map을 벗어난 경우
                if(y < 0 || y >= yLen || x < 0 || x >= xLen) continue;
                // 벽인경우
                if(maps[y][x] == 0) continue;
                // 이미 방문한 경우
                if(check[y][x] != 0) continue;
                // 경로 누적합
                check[y][x] = check[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{y, x});
            }
        }
        // 탈출로 누적합 추출
        int answer = check[yLen - 1][xLen - 1];
        return answer == 0 ? -1 : answer + 1;
    }

    public static void main(String[] args) {
        게임_맵_최단거리 res = new 게임_맵_최단거리();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(res.solution(maps));
    }
}
