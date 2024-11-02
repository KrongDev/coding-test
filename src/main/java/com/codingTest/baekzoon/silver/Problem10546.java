package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            String player = br.readLine();
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for(int i = 0; i < len - 1; i++) {
            String player = br.readLine();
            map.put(player, map.getOrDefault(player, 0) - 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0) {
                System.out.println(entry.getKey());
            }
        }
    }
}
