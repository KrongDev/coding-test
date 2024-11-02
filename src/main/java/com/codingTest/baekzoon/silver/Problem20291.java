package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s = br.readLine();
            int index = s.indexOf(".");
            String str = s.substring(index + 1);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey()).forEach(entry -> sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n"));
        System.out.println(sb);
    }
}
