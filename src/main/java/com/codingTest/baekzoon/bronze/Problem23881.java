package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem23881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[2];
        for(int i = N - 1; i > 0; i--) {
            int index = getMinValueIndex(arr, i);
            if(i != index) {
                res[0] = arr[i];
                res[1] = arr[index];
                swap(arr, i, index);
                K--;
            }
            if(K == 0) break;
        }

        StringBuilder sb = new StringBuilder();
        if(K > 0) sb.append(-1);
        else sb.append(res[0]).append(" ").append(res[1]);
        System.out.println(sb);
    }


    private static int getMinValueIndex(int[] arr, int end) {
        int res = 0;
        for(int i = 1; i <= end; i++) {
            if(arr[res] < arr[i]) {
                res = i;
            }
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
