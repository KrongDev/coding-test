package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 팀갯수
        int N = Integer.parseInt(st.nextToken());
        // 문제수
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> member = new HashMap<>();
        Map<String, SortedSet<String>> team = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int count = Integer.parseInt(br.readLine());
            SortedSet<String> memberSet = new TreeSet<>();
            for(int j = 0; j < count; j++) {
                String memberName = br.readLine();
                member.put(memberName, teamName);
                memberSet.add(memberName);
            }
            team.put(teamName, memberSet);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String searchValue = br.readLine();
            String searchType = br.readLine();
            switch (searchType) {
                case "0":
                    team.get(searchValue).forEach(s->sb.append(s).append("\n"));
                    break;
                case "1":
                    sb.append(member.get(searchValue)).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
