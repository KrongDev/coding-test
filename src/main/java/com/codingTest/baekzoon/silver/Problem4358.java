package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Problem4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<String, Integer> map = new TreeMap<>();
        String str;
        int totalCount = 0;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            totalCount++;
        }
        double oneValue = 100d/totalCount;
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key).append(" ").append(String.format("%.4f", value * oneValue)).append("\n"));
        System.out.println(sb);
    }
}
