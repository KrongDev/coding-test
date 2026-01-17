package com.codingTest.baekzoon.gold;

import java.io.*;
import java.util.*;

/**
 * ▣ 문제: 백준: 1005 - ACM Craft
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N*K)
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while((T--)>0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            // 건축 순서
            List<Integer>[] arr = new ArrayList[N + 1];
            int[] indegree = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                indegree[y]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            int[] dp = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                dp[i] = D[i];
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(int next : arr[cur]) {
                    dp[next] = Math.max(dp[next], dp[cur] + D[next]);
                    indegree[next]--;

                    if(indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            bw.write(dp[W] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
