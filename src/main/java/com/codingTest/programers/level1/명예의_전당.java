package com.codingTest.programers.level1;


import java.util.*;

public class 명예의_전당 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < score.length; i++) {
            list.add(score[i]);

            if(list.size() > k) {
                list.remove(min(list));
            }
            answer[i] = min(list);
        }
        return answer;
    }

    public <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) {
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) < 0)
                candidate = next;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] score = new int[]{10, 100, 20, 150, 1, 100, 200};

        명예의_전당 res = new 명예의_전당();
        System.out.println("res = " + Arrays.toString(res.solution(k, score)));
    }
}
