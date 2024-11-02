package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, i);
        }
        int answer = 0;
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            int index = map.get(br.readLine());
            for(int j = index - 1; j >= 0; j--) {
                if(!visited[j]) {
                    answer++;
                    break;
                }
            }
            visited[index] = true;
        }

        System.out.println(answer);
    }
}
