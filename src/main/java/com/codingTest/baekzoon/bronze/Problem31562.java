package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem31562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int singLen = Integer.parseInt(st.nextToken());
        int codeLen = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < singLen; i++) {
            st = new StringTokenizer(br.readLine());
            int titleLen = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            String str = st.nextToken() + " " + st.nextToken() + " " + st.nextToken();
            String prevTitle = map.get(str);
            if(prevTitle != null) {
                map.put(str, "?");
            } else {
                map.put(str, title);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < codeLen; i++) {
            sb.append(map.getOrDefault(br.readLine(), "!")).append("\n");
        }
        System.out.println(sb);
    }
}
