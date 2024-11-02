package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;
        String str;
        for(int i = 0; i < len; i++) {
            str = br.readLine();
            if("ENTER".equals(str)) {
                answer += set.size();
                if(!set.isEmpty())
                    set = new HashSet<>();
                continue;
            }
            set.add(str);
        }
        if(!set.isEmpty())
            answer += set.size();
        System.out.println(answer);
    }
}
