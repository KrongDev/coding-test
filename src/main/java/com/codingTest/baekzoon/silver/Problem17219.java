package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int passwordLen = Integer.parseInt(st.nextToken());
        int siteLen = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < passwordLen; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < siteLen; i++) {
            sb.append(map.getOrDefault(br.readLine(),"")).append("\n");
        }
        System.out.println(sb);
    }
}
