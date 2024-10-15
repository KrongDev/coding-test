package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem14713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        List<Queue<String>> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String[] str = br.readLine().split(" ");
            Queue<String> queue = new ArrayDeque<>(Arrays.asList(str));
            arr.add(queue);
        }

        String[] str = br.readLine().split(" ");
        String res = "Possible";

        // 주어진 문장 L의 단어들을 순서대로 처리
        for (String s : str) {
            boolean found = false;
            for (Queue<String> queue : arr) {
                // 현재 단어가 어떤 큐의 맨 앞과 일치하면 제거
                if (!queue.isEmpty() && s.equals(queue.peek())) {
                    queue.poll();
                    found = true;
                    break;
                }
            }
            // 어느 큐에서도 단어를 찾지 못한 경우
            if (!found) {
                res = "Impossible";
                break;
            }
        }

        // 모든 큐가 비워져야 최종적으로 "Possible"
        for (Queue<String> queue : arr) {
            if (!queue.isEmpty()) {
                res = "Impossible";
                break;
            }
        }

        System.out.println(res);
    }
}
