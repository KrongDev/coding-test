package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            Map<Integer, Integer> rule = new HashMap<>();
            int len = Integer.parseInt(br.readLine());

            Map<String, Integer> firstMap = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                firstMap.put(st.nextToken(), j);
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                rule.put(j, firstMap.get(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            SortedMap<Integer, String> sortedMap = new TreeMap<>();
            for(int j = 0; j < len; j++) {
                sortedMap.put(rule.get(j), st.nextToken());
            }
            sortedMap.forEach((key, value) -> sb.append(value).append(" "));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
