package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        int total = set.size();

        int answer = 0;
        switch (type) {
            case "Y":
                answer = total;
                break;
            case "F":
                answer = total/2;
                break;
            case "O":
                answer = total/3;
                break;
        }
        System.out.println(answer);
    }
}
