package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1991 {
    public static BufferedWriter bw;
    public static int N;
    public static Map<Integer, String> index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        //Index Map
        Map<String, Integer> map = new HashMap<>();
        index = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            int parentIndex = map.getOrDefault(parent, 0);
            index.put(parentIndex, parent);
            map.put(parent, parentIndex);
            String left = st.nextToken();
            String right = st.nextToken();
            int leftIndex = map.get(parent) * 2 + 1;
            int rightIndex = map.get(parent) * 2 + 2;
            map.put(left, leftIndex);
            map.put(right, rightIndex);
            index.put(leftIndex, left);
            index.put(rightIndex, right);
        }
        printPrev(0);
        bw.write("\n");
        printIn(0);
        bw.write("\n");
        printPost(0);
        bw.flush();
    }

    public static boolean isEmpty(String text) {
        return text.isEmpty() || text.isBlank() || ".".equals(text);
    }

    public static void printPrev(int i) throws IOException {
        String node = index.get(i);
        if(isEmpty(node)) return;
        bw.write(node);
        printPrev(i * 2 + 1);
        printPrev(i * 2 + 2);
    }

    public static void printIn(int i) throws IOException {
        String node = index.get(i);
        if(isEmpty(node)) return;
        printIn(i * 2 + 1);
        bw.write(node);
        printIn(i * 2 + 2);
    }

    public static void printPost(int i) throws IOException {
        String node = index.get(i);
        if(isEmpty(node)) return;
        printPost(i * 2 + 1);
        printPost(i * 2 + 2);
        bw.write(node);
    }
}
