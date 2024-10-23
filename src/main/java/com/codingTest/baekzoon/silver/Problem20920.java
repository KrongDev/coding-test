package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() < M) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        StringBuilder sb = map.entrySet().stream().sorted((prev, now) -> {
            if(prev.getValue() != now.getValue()) return now.getValue() - prev.getValue() ;
            if(prev.getKey().length() != now.getKey().length()) return now.getKey().length() - prev.getKey().length();
            return prev.getKey().compareTo(now.getKey());
        }).reduce(new StringBuilder(), (prev, now) -> prev.append(now.getKey()).append("\n"), StringBuilder::append);
        System.out.println(sb);
    }
}
