package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startEnd = changeTime(st.nextToken());
        int endStart = changeTime(st.nextToken());
        int endEnd = changeTime(st.nextToken());

        Set<String> member = new HashSet<>();
        int answer = 0;
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str);
            int time = changeTime(st.nextToken());
            String player = st.nextToken();
            if(checkIn(time, startEnd, time)) {
                member.add(player);
                continue;
            }
            if(checkIn(endStart, endEnd, time) && member.contains(player)) {
                answer++;
                member.remove(player);
            }
        }
        System.out.println(answer);
    }

    public static int changeTime (String time) {
        return Integer.parseInt(time.replace(":", ""));
    }

    public static boolean checkIn(int start, int end, int time) {
        return start <= time && time <= end;
    }
}
