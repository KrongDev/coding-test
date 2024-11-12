package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<Integer>[] arr = new List[N + 1];
        for( int i = 1; i <= N; i++ ) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
            arr[to].add(from);
        }

        int[] parent = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for(int child: arr[current]){
                if (parent[child] == 0) {
                    parent[child] = current;
                    queue.add(child);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
