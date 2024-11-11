package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String to = st.nextToken();
                map.put(to, map.get(to) + 1);
            }
        }

        StringBuilder answer = map.entrySet().stream().sorted((prev, now) -> {
            if(prev.getValue() != now.getValue()) return now.getValue() - prev.getValue();
            return prev.getKey().compareTo(now.getKey());
        }).reduce(new StringBuilder(),(sb, entry) -> sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n"),StringBuilder::append);
        System.out.println(answer);
    }
}
