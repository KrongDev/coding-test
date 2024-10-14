package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            String changeStr = new StringBuilder(str).reverse().toString();
            map.put(changeStr, map.getOrDefault(changeStr, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                int strLen = entry.getKey().length();
                sb.append(strLen).append(" ").append(entry.getKey().charAt(strLen/2));
                break;
            }
        }
        System.out.println(sb);
    }
}
