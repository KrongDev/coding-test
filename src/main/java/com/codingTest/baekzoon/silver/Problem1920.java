package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aLen = Integer.parseInt(br.readLine());
        Map<Integer, Boolean> a = new HashMap<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < aLen; i++) {
            a.put(Integer.parseInt(st.nextToken()), true);
        }
        int bLen = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < bLen; i++) {
            if(a.getOrDefault(Integer.parseInt(st.nextToken()), false)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
