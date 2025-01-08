package com.codingTest.programers.level1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {

    int[] arr;
    Map<Character, Integer> map;
    Map<Integer, Character> charMap;

    public 성격_유형_검사하기() {
        arr = new int[8];
        map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 4);
        map.put('C', 1);
        map.put('F', 5);
        map.put('J', 2);
        map.put('M', 6);
        map.put('A', 3);
        map.put('N', 7);

        charMap = new HashMap<>();

        charMap.put(0, 'R');
        charMap.put(4, 'T');
        charMap.put(1, 'C');
        charMap.put(5, 'F');
        charMap.put(2, 'J');
        charMap.put(6, 'M');
        charMap.put(3, 'A');
        charMap.put(7, 'N');
    }

    public String solution(String[] survey, int[] choices) {
        for(int i = 0; i < survey.length; i++) {
            addScore(survey[i], choices[i]);
        }
        return makeAnswer();
    }

    private void addScore(String survey, int choices) {
        if(choices == 4) return;
        boolean affirmation = choices > 4;
        int score = affirmation ? choices - 4 : 4 - choices ;

        if(affirmation) arr[map.get(survey.charAt(1))] += score;
        else arr[map.get(survey.charAt(0))] += score;
    }

    private String makeAnswer() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            if(arr[i] > arr[i + 4] || arr[i] == arr[i + 4])
                sb.append(charMap.get(i));
             else
                sb.append(charMap.get(i + 4));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        성격_유형_검사하기 res = new 성격_유형_검사하기();
        System.out.println(res.solution(survey, choices));
    }
}
