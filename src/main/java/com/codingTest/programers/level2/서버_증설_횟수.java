package com.codingTest.programers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {
        int n = players.length;

        // 서버 수 같은시간대 조건
        // m명 늘어날 때마다 1대씩 추가
        // m명 미만이면 유지
        // min 이상 max 미만이라면 최소 n대의 증설된 서버가 운영중
        // 한번 증설한 서버는 k시간 동안 운영 이후 반납(필수) 만약 m명 이상이면 반납 후 증설
        // 모두 게임을 하려면 서버 증설 횟수는 몇회인가? <= answer
        int answer = 0;

        // 고민: 증설된 서버의 count를 어떻게 관리할까? 정답 Queue로 관리한다.
        int serverCount = 0;
        Queue<Integer> server = new LinkedList<>();
        // 서버 유지시간이 5이니 미리 5시간을 0으로 채워준다.
        for(int i = 0; i < k; i++) {
            server.add(0);
        }

        for(int i = 0; i < n; i++) {
            // 현재 할당된 서버 제거
            int overServer = server.poll();
            serverCount -= overServer;
            //현재 이용중인 플레이어
            int playerCount = players[i];

            if(playerCount < m) {
                server.add(0);
                continue;
            }

            ///  현재 최소 운영되어야하는 서버수
            int nowServerCount = playerCount/m;
            if(nowServerCount > serverCount) {
                int addServerCount = nowServerCount - serverCount;
                answer += addServerCount;
                serverCount += addServerCount;
                server.add(addServerCount);
                continue;
            }

            server.add(0);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] players = {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        int m = 1, k = 1;

        서버_증설_횟수 res = new 서버_증설_횟수();
        System.out.println(res.solution(players, m, k));
    }
}
