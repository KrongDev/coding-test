package com.codingTest.programers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> pushDay = new LinkedList<>();
        int length = progresses.length;
        int workDay = 0;
        int pushNum = 0;
        for (int i = 0; i< length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int nowWorkJob = nowWorkJob(progress, speed, workDay);
            if(isFinish(nowWorkJob)) {
                pushNum++;
            } else {
                if(i != 0) pushDay.add(pushNum);
                workDay += addWorkDay(nowWorkJob, speed);
                pushNum = 1;
            }
            if(i == length - 1) pushDay.add(pushNum);
        }

        return pushDay.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int nowWorkJob (int progress, int speed, int worDay) {
        //
        return progress + (speed*worDay);
    }

    public boolean isFinish (int nowWorkJob) {
        //
        return 100 <= nowWorkJob;
    }

    public int addWorkDay (int nowWorkJob, int speed) {
        //
        int remain = 100 - nowWorkJob;

        int addDay = remain/speed;
        addDay += remain%speed > 0 ? 1 : 0;

        return addDay;
    }
}
