package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem24060 {
    private static int answer = -1;
    private static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new  StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N-1);

        System.out.println(answer);
    }

    private static void merge_sort(int[] arr, int p, int r) {
        if(p >= r) return;
        int q = Math.abs((p + r)/2);
        merge_sort(arr, p, q);
        merge_sort(arr, q+1, r);
        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] temp = new int[r - p + 1];
        while(i <= q && j <= r) {
            if(arr[i] <= arr[j]) temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }

        while(i <= q) temp[t++] = arr[i++];
        while(j <= r) temp[t++] = arr[j++];
        for(int k = 0; k < temp.length; k++){
            arr[p + k] = temp[k];
            if(--K == 0) {
                answer = temp[k];
            }
         }
    }
}
