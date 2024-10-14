package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 1);
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String left = st.nextToken();
            String right = st.nextToken();
            int leftCount = map.getOrDefault(left, 0);
            int rightCount = map.getOrDefault(right, 0);
            if(leftCount > 0 || rightCount > 0) {
                map.put(left, leftCount + 1);
                map.put(right, rightCount + 1);
            }
        }

        int answer = 0;
        for(int value: map.values()) {
            if(value > 0) answer++;
        }
        System.out.println(answer);
    }
}
