package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem23968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] inputArr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        int[] changeData = new int[2];
        int changeCount = 0;
        boolean change = false;
        be: for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    changeData[0] = arr[j];
                    changeData[1] = arr[j + 1];
                    arr[j] = changeData[1];
                    arr[j + 1] = changeData[0];
                    changeCount++;
                    change = true;
                    if(changeCount == K) {
                        break be;
                    }
                }
            }
            if(!change) break;
        }

        if(changeCount == K) {
            System.out.println(Math.min(changeData[0], changeData[1]) + " " + Math.max(changeData[0], changeData[1]));
        } else {
            System.out.println(-1);
        }
    }
}

