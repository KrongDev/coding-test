package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class Problem3584 {

    static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int N = Integer.parseInt(br.readLine());
            nodes = new int[N + 1];
            for(int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                // B의 부모 노드
                int A = Integer.parseInt(st.nextToken());
                // A의 부모 노드
                int B = Integer.parseInt(st.nextToken());
                nodes[B] = A;
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int answer = LCA(a, b);
            bw.write(answer + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    // 두 노드의 공통 조상노드 찾기
    private static int LCA(int a, int b) {
        boolean[] parents = new boolean[nodes.length];

        while(true) {
            parents[a] = true;
            parents[b] = true;
            int aParent = nodes[a];
            int bParent = nodes[b];

            if(aParent == 0 && bParent == 0){
                return a;
            }

            if(aParent == bParent) {
                return aParent;
            }

            if(parents[aParent]) {
                return aParent;
            }
            if(parents[bParent]) {
                return bParent;
            }
            if(aParent != 0) {
                a = aParent;
            }
            if(bParent != 0) {
                b = bParent;
            }
        }
    }
}
