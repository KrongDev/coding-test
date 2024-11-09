package com.codingTest.baekzoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2358 {

    static Map<Integer, Integer> xLineMap = new HashMap<>();
    static Map<Integer, Integer> yLineMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            xLineMap.put(x, xLineMap.getOrDefault(x, 0) + 1);
            yLineMap.put(y, yLineMap.getOrDefault(y, 0) + 1);
        }
        int answer = 0;
        for (int count : xLineMap.values()) {
            if (count > 1) {
                answer++;
            }
        }
        for (int count : yLineMap.values()) {
            if (count > 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
