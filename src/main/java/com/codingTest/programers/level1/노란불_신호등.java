package com.codingTest.programers.level1;

// 2025 카카오 하반기 1차 - 노란불 신호등
// 모든 신호등은 사이클 길이(G+Y+R)의 최소공배수마다 처음 상태로 돌아오므로
// 1초 ~ LCM초까지만 확인하면 된다. 그 안에 없으면 영원히 없음(-1)
public class 노란불_신호등 {
    public int solution(int[][] signals) {
        int len = signals.length;
        int[] signalLengthArr = new int[len];
        signalLengthArr[0] = getSignalLength(signals[0]);

        int lcm = signalLengthArr[0];
        for(int i = 1; i < len; i++) {
            signalLengthArr[i] = getSignalLength(signals[i]);
            lcm = LCM(lcm, signalLengthArr[i]);
        }

        boolean check;
        for(int t = 1; t <= lcm; t++) {
            check = true;
            for(int i = 0; i < len; i++) {
                if(!isYellow(signals[i], signalLengthArr[i], t)) {
                    check = false;
                    break;
                }
            }
            // 모든 신호등을 확인한 뒤에 판단
            if(check) return t;
        }

        return -1;
    }

    private int getSignalLength(int[] signal) {
        int res = 0;
        for(int a: signal) {
            res += a;
        }
        return res;
    }

    // 사이클 안 위치(1부터)가 G < 위치 <= G+Y 이면 노란불
    // 나머지가 0인 경우(사이클 마지막 초)는 R >= 1 이라 항상 빨간불 → false로 처리됨
    private boolean isYellow(int[] signal, int len, int t) {
        int checkT = t % len;
        return signal[0] < checkT && checkT <= signal[0] + signal[1];
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private int LCM(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
