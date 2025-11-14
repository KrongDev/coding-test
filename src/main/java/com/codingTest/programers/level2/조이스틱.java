package com.codingTest.programers.level2;

class 조이스틱 {
    private boolean[] map;
        
    private int numberChange(char c) {
        int forwardMove = c - 'A';
        int backwardMove = 'Z' - c + 1;
        
        return Math.min(forwardMove, backwardMove);
    }
    
    public int solution(String name) {
        int N = name.length();
        int answer = 0;
        int minMove = N - 1;
        
        for (int i = 0; i < N; i++) {
            answer += numberChange(name.charAt(i));
        }
        
        for (int i = 0; i < N; i++) {
            int next = i + 1;
            
            while (next < N && name.charAt(next) == 'A') {
                next++;
            }
            
            // i까지 갔다가(i) 되돌아와서(i) next 위치부터 시작하는 거리 계산 (오른쪽 먼저)
            // next부터 끝까지는 (N - next)
            int moveRightFirst = (i * 2) + (N - next); 
            
            // next부터 먼저 갔다가 (N - next) 되돌아와서 (N - next) i까지 가는 거리 계산 (왼쪽 먼저)
            int moveLeftFirst = (N - next) * 2 + i;
            
            // 세 가지 경로 중 최솟값 갱신
            minMove = Math.min(minMove, moveRightFirst);
            minMove = Math.min(minMove, moveLeftFirst);
        }
        
        return answer + minMove;
    }
}
