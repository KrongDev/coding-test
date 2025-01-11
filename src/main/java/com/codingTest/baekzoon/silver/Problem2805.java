package com.codingTest.baekzoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int min = 0;
        int max = getMax(trees);

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int tree : trees) {
                if(tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if(sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min - 1));
        bw.flush();
        bw.close();
    }

    public static int getMax(int[] trees) {
        int max = 0;
        for(int tree: trees) {
           if(tree > max) max = tree;
        }
        return max;
    }
}
