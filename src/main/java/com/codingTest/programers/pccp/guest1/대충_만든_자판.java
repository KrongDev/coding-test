package com.codingTest.programers.pccp.guest1;

import java.util.Arrays;

public class 대충_만든_자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int targetLength = target.length();
            for(int j=0;j<targetLength;j++){
                char targetChar = target.charAt(j);
                int index = this.getCharIndex(keymap, targetChar);
                if(index == -1) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += (index + 1);
            }
        }
        return answer;
    }

    private int getCharIndex(String[] keymap, char c) {
        int index = -1;
        for(String key:keymap){
            for(int i = 0; i < key.length(); i++){
                if(key.charAt(i) == c){
                    if(index == -1 || index > i) index = i;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] keymap = {"AA"};
        String[] targets = {"B"};
        대충_만든_자판 res = new 대충_만든_자판();
        System.out.println(Arrays.toString(res.solution(keymap, targets)));
    }
}
