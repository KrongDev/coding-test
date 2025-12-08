package com.codingTest.leetcode;

public class Button_with_Longest_Push_Time {
    public int buttonWithLongestTime(int[][] events) {
        int res = events[0][0];
        int resTime = events[0][1];
        for(int i = 1; i < events.length; i++) {
            int pressTime = events[i][1] - events[i - 1][1];
            if(pressTime > resTime || (pressTime == resTime && events[i][0] < res)) {
                res = events[i][0];
                resTime = pressTime;
            }
        }
        return res;
    }
}
