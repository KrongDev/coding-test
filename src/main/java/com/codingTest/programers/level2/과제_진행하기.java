package com.codingTest.programers.level2;

import java.util.*;

public class 과제_진행하기 {
    class NameTime{
        String name;
        int time;

        NameTime(String name, int time) {
            this.name = name;
            this.time = time;
        }

        int minusTime(int time) {
            this.time -= time;
            return this.time;
        }
    }

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparing(o -> o[1]));

        Stack<NameTime> stack = new Stack<>();
        int answerIndex = 0;
        String[] answer = new String[plans.length];
        for(int i = 0; i < plans.length - 1; i++) {
            String[] plan = plans[i];
            int[] time = getTimes(plan[1]);
            int minute = getMinute(plan[2]);

            String[] nextPlan = plans[i+1];
            int[] nextTime = getTimes(nextPlan[1]);
            /**
             * 20분 사용해야하고 40분 남은 경우? 40 - 20 = 잔여분 20
             * 40분 사용해야하고 20분 남은 경우 ? 20 - 40 = -20분 => 40 - 20 = 20분 더해야함
             *
             * 알고리즘 정책
             * 총 남는 시간에서 사용해야하는 시간을 뺌
             *
             */
            int gapTime = gapMinute(time, nextTime);
            int andTime = gapTime - minute;
            if(andTime < 0) {
                stack.push(new NameTime(plan[0], minute - (minute + andTime)));
                continue;
            }

            answer[answerIndex++] = plan[0];

            /**
             * 시간이 남았으니 남은 시간 사용
             */
            while (!stack.isEmpty()) {
                NameTime prev = stack.pop();
                int checkTime = andTime - prev.time;
                if(checkTime < 0) {
                    prev.minusTime(prev.time - (prev.time + checkTime));
                    stack.push(prev);
                    break;
                }
                andTime = checkTime;
                answer[answerIndex++] = prev.name;
            }
        }

        // 마지막 처리
        answer[answerIndex++] = plans[plans.length - 1][0];
        while(!stack.isEmpty()) {
            answer[answerIndex++] = stack.pop().name;
        }

        return answer;
    }

    int[] getTimes(String time) {
        return Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
    }

    int getMinute(String minute) {
        return Integer.parseInt(minute);
    }

    // 다음 작업 시간 전 남는 분 계산
    int gapMinute(int[] nowStartTime, int[] nextStartTime) {
        int hourGap = nextStartTime[0] - nowStartTime[0];
        int minuteGap = nextStartTime[1] - nowStartTime[1];
        return hourGap * 60 + minuteGap;
    }

    public static void main(String[] args) {
        과제_진행하기 res = new 과제_진행하기();
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(res.solution(plans)));
    }
}
