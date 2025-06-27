package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem23969 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 처리를 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 버블 정렬 및 K번째 교환 찾기
        int swapCount = 0;

        // 외부 루프: n-1 부터 1까지 역순으로 진행 (각 패스)
        for (int i = n - 1; i > 0; i--) {
            // 내부 루프: 0부터 i-1까지 인접 원소 비교
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // 원소 교환 (swap)
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swapCount++;

                    // 교환 횟수가 K에 도달했는지 확인
                    if (swapCount == k) {
                        // K번째 교환 후의 배열 상태 출력
                        // StringBuilder를 사용해 효율적으로 문자열을 만듦
                        StringBuilder sb = new StringBuilder();
                        for (int val : a) {
                            sb.append(val).append(" ");
                        }
                        System.out.println(sb.toString().trim());
                        return; // 프로그램 종료
                    }
                }
            }
        }

        // 3. K번 교환이 일어나기 전에 정렬이 완료된 경우
        System.out.println(-1);
    }
}

