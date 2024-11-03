package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Problem9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        for(int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());

            String str = null;
            while ((str = br.readLine()) != null && !str.isEmpty() ) {
                if("what does the fox say?".equals(str)) {
                    break;
                }
                st = new StringTokenizer(str);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    int index = sb.indexOf(token);
                    if(index != -1) {
                        sb.delete(index, index + token.length());
                    }
                }
            }
            answer.append(sb);
            answer.append("\n");
        }
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put()
        System.out.println(answer);
    }
}
