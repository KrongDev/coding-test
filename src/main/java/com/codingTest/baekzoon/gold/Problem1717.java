package com.codingTest.baekzoon.gold;

import java.io.*;

import java.util.StringTokenizer;


public class Problem1717 {
    private static int[] arr;

    // 합쳐진 주체의 번호를 입력하여 본인이 어디에 속해있는지 알게함.
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            arr[rootB] = rootA;
        }
    }

    // 본인의 부모번호를 찾아가며, 본인의 부모또한 다른 집합에 합쳐졌다면 이를 찾아 최신 Root경로로 수정한다.
    public static int find(int num) {
        if (arr[num] != num) {
            arr[num] = find(arr[num]);
        }
        return arr[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        while((m--) > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) bw.append("YES\n");
                else bw.append("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
