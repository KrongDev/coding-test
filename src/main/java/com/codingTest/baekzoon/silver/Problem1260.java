package com.codingTest.baekzoon.silver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Problem1260 {
    private static int[][] graph;
    private static boolean[] visited;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        // graph 구축
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = to;
            graph[to][from] = from;
        }

        visited = new boolean[n + 1];
        visited[root] = true;
        dfs(root);
        sb.append("\n");
        visited = new boolean[n + 1];
        visited[root] = true;
        bfs(root);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int index) {
        sb.append(index).append(" ");

        for(int child : graph[index]) {
            if(child != 0 && !visited[child]) {
                visited[child] = true;
                dfs(child);
            }
        }
    }

    private static void bfs(int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(graph[index]);
        sb.append(index).append(" ");
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int child : node) {
                if(child != 0 && !visited[child]) {
                    visited[child] = true;
                    sb.append(child).append(" ");
                    queue.add(graph[child]);
                }
            }
        }
    }
}
