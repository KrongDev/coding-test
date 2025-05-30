package com.codingTest.programers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 몸풀기_1부터_N까지의_숫자_더하기 {

    private final List<Integer[]> answer = new ArrayList<>();
    private List<Integer> bucket;
    private int N;

    public List<Integer[]> solution(int N) {
        this.N = N;
        this.bucket = new ArrayList<>();
        dfs(0, 0);
        return answer;
    }

    private void dfs(int total, int num) {
        if(total == 10) {
            answer.add(copyList(bucket));
            return;
        }

        for(int i = num + 1; i <= N; i++) {
            if(total + i > 10) continue;
            bucket.add(i);
            dfs(total + i, i);
            bucket.removeLast();
        }
    }

    private Integer[] copyList(List<Integer> list) {
        int length = list.size();
        Integer[] copy = new Integer[length];
        System.arraycopy(list.toArray(), 0, copy, 0, length);
        return copy;
    }

    public static void main(String[] args) {
        몸풀기_1부터_N까지의_숫자_더하기 res = new 몸풀기_1부터_N까지의_숫자_더하기();
        int N = 15;
        List<Integer[]> answer = res.solution(N);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Integer[] array : answer) {
            sb.append(Arrays.toString(array));
            sb.append(", ");
        }



        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb);
    }
}
