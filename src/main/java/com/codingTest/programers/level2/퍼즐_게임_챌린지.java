package com.codingTest.programers.level2;

public class 퍼즐_게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;

        while(left < right){
            long mid = (left + right) / 2;

            if(isImpossible(diffs, times, mid, limit)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int)left;
    }

    private boolean isImpossible(int[] diffs, int[] times, long level, long limit){
        long t = (long)times[0];

        for(int i =1; i<times.length; i++){
            if(diffs[i] > level){
                t += ((long)diffs[i] - level) * ((long)times[i-1] + (long)times[i]);
            }
            t += (long)times[i];
        }

        return limit < t;
    }

    public static void main(String[] args) {
        퍼즐_게임_챌린지 res = new 퍼즐_게임_챌린지();
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        long limit = 30;
        System.out.println(res.solution(diffs, times, limit));
    }
}
