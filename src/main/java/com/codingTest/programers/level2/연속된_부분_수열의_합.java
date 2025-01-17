package com.codingTest.programers.level2;

import java.util.Arrays;

public class 연속된_부분_수열의_합 {

    public int[] solution(int[] sequence, int k) {

        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L - 1;
                if((right - left) > range) {
                    left = L;
                    right = R - 1;
                }
            }

            sum -= sequence[L];
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        연속된_부분_수열의_합 res = new 연속된_부분_수열의_합();
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(Arrays.toString(res.solution(sequence, k)));
    }
}
