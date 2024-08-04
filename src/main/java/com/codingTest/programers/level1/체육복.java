package com.codingTest.programers.level1;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int len = n + 1;
        int[] child = new int[len];

        for(int i: lost) child[i]--;
        for(int r: reserve) child[r]++;

        int miner = 0;
        for(int i = 0; i < len; i++) {
            if(child[i] == -1) {
                if(i != 0 && child[i - 1] == 1) child[i - 1] = 0;
                else if (i != len - 1 && child[i + 1] == 1) child[i + 1] = 0;
                else miner++;
            }
        }

        return n - miner;
    }
}
