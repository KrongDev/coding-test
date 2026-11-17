package com.codingTest.programers.level1;

// 2025 프로그래머스 코드챌린지 1차 예선 - 유연근무제
// 마감 시각 = 희망 시각 + 10분 (분이 60 이상이면 시 올림)
// 요일 = (startday - 1 + ti) % 7, 5(토)·6(일)은 건너뜀
public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        // 요일 0 = 월요일
        // t = 시, m = 분, tlt = 출근시, tlm =출근분
        int t, m, tlt, tlm;
        // 지각 여부
        boolean check;
        for(int si = 0; si < schedules.length; si++) {
            // 기본 설정 초기화
            check = false;

            t = schedules[si]/100;
            m = schedules[si]%100;

            m += 10;
            if(t < 23 && m >= 60) {
                t++;
                m %= 60;
            }
            for(int ti = 0; ti < timelogs[si].length; ti++) {
                // 주말이 아닌 평일만 지각을 체크한다.
                // 5 = 토, 6 = 일
                if((startday-1+ti)%7 > 4) continue;
                // 지각 여부 계산
                // schedule이 본인 출근 희망 시간
                // 출근 희망 시간 + 10분까지는 정상 출근으로 친다.
                // 들어오는 숫자는 9시 30분이면 930으로 온다.
                // 60분은 없다. 즉, 00분이 존재한다. %= 60
                // 24시는 없다. 즉, 출근시간은 최대 23시 59분이다.
                tlt = timelogs[si][ti]/100;
                tlm = timelogs[si][ti]%100;
                // 일찍 출근했다면 뺀다.
                if(tlt < t || (tlt == t && tlm <= m)) continue;

                // 지각 했다면
                check = true;
                break;
            }
            // 지각하지 않았다면 answer + 1
            if(!check)
                answer++;
        }

        return answer;
    }
}
