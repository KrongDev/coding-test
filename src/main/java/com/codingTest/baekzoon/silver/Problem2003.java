package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] strs = br.readLine().split(" ");
        int[] nums = new int[N];

        int answer = 0;
        int left = -1, right = 0;
        int sum = 0;
        while(left < right) {
            while (right < N && sum < M) {
                nums[right] = Integer.parseInt(strs[right]);
                sum += nums[right++];
            }
            if(sum == M) {
                answer++;
            }

            if(left == N - 1) break;
            sum -= nums[++left];
        }
        System.out.println(answer);
    }
}
