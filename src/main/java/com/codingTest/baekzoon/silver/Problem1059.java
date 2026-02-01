package com.codingTest.baekzoon.silver; /**
 * ▣ 문제: 백준 1059 - 좋은 구간
 * ▣ 알고리즘: 정렬 (Sorting), 브루트포스 또는 수학적 계산
 * ▣ 시간 복잡도: O(L log L) - L은 집합 S의 크기 (정렬이 지배적임)
 * * [풀이 전략]
 * 1. 집합 S를 오름차순으로 정렬하여 n이 위치한 인접한 두 원소(경계)를 찾는다.
 * 2. n이 이미 S에 포함되어 있다면 조건을 만족하는 구간이 없으므로 0을 출력한다.
 * 3. n을 포함하면서 S의 원소를 포함하지 않는 최소값(left+1)과 최대값(right-1) 범위를 구한다.
 * 4. A < B 조건을 만족하도록 (n을 포함하는 경우의 수)를 조합론적으로 계산한다.
 */
import java.io.*;
import java.util.*;

public class Problem1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] s = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        Arrays.sort(s);

        int left = 0;
        int right = 0;
        boolean found = false;

        for (int num : s) {
            if (num == n) {
                found = true;
                break;
            }
            if (num < n) {
                left = num;
            } else {
                right = num;
                break;
            }
        }

        if (found) {
            bw.write("0\n");
        } else {
            int start = left + 1;
            int end = right - 1;

            int result = (n - start) * (end - n + 1) + (end - n);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}