package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem5568 {

    private static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    private static int maxSize;
    private static int maxDepth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        maxSize = Integer.parseInt(br.readLine());
        maxDepth = Integer.parseInt(br.readLine());

        visited = new boolean[maxSize];
        String[] arr = new String[maxSize];
        for(int i = 0; i < maxSize; i++) {
            arr[i] = br.readLine();
        }

        genNumber(arr, "", 0);
        System.out.println(set.size());
    }

    public static void genNumber(String[] arr, String res, int depth) {
        if(maxDepth == depth) {
            set.add(Integer.parseInt(res));
            return;
        }

        for(int i = 0; i < maxSize; i++) {
            if(!visited[i]) {
                visited[i] = true;
                genNumber(arr, res + arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
