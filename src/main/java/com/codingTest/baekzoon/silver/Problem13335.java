package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 트럭 수
        int n = Integer.parseInt(st.nextToken());
        // 다리 길이
        int L = Integer.parseInt(st.nextToken());
        // 다리 최대 감당 하중
        int W = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new LinkedList<>();
        String[] trucks = br.readLine().split(" ");
        int sec = 0;
        int trucksWeight = 0;

        int idx = 0;
        while (idx < n) {
            int truck = Integer.parseInt(trucks[idx]);
            if(bridge.isEmpty()) {
                bridge.add(truck);
                trucksWeight += truck;
                sec++;
                idx++;
                continue;
            }

            if (bridge.size() == L) {
                trucksWeight -= bridge.poll();
                continue;
            } else if (trucksWeight + truck <= W) {
                bridge.add(truck);
                trucksWeight += truck;
                sec++;
                idx++;
                continue;
            }
            bridge.add(0);
            sec++;
        }
        System.out.println(sec + L);
    }
}
