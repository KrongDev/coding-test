package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.*;

public class Problem1068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] parents = new int[N];
        boolean[] isDeleted = new boolean[N];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1) {
                root = i;
            } else {
                graph.get(parents[i]).add(i);
            }
        }
        int deleteNode = Integer.parseInt(br.readLine());
        if(parents[deleteNode] > -1) {
            delete(graph.get(parents[deleteNode]), isDeleted, deleteNode);
        } else {
            isDeleted[root] = true;
        }
        bw.write(countLeafNode(graph, isDeleted, root) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void delete(List<Integer> graph, boolean[] isDeleted, int node) {
        for(int child : graph) {
            if(child == node) {
                isDeleted[child] = true;
                return;
            }
        }
    }

    public static int countLeafNode(List<List<Integer>> graph, boolean[] isDeleted, int node) {
        if(isDeleted[node]) return 0;
        if(graph.get(node).isEmpty()) return 1;
        int count = 0;

        for(int child : graph.get(node)) {
            count += countLeafNode(graph, isDeleted, child);
        }

        return count == 0 ? 1 : count;
    }
}
