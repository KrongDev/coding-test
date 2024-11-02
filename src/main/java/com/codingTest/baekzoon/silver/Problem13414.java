package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();
        for(int i = 0; i < L; i++) {
            String str = br.readLine();
            Integer check = map.get(str);
            if( check != null) {
                indexMap.remove(check);
            }
            indexMap.put(i, str);
            map.put(str, i);
        }
        StringBuilder sb = new StringBuilder();
        int check = 0;
        for(int i = 0; i < L; i++) {
            if(indexMap.containsKey(i)) {
                sb.append(indexMap.get(i)).append("\n");
                check++;
            }
            if(check == K) break;
        }
        System.out.println(sb);
    }
}
