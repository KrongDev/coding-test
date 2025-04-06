package com.codingTest.programers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {

    Set<String> set = new HashSet<>();

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 1번이 처음부터 실패하면 죽임
        if(words[0].length() == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }

        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String word = words[i];

            if(isValidWord(prevWord, word)) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }

            set.add(word);
        }

        return answer;
    }

    /**
     * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
     * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
     * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
     * 이전에 등장했던 단어는 사용할 수 없습니다.
     * 한 글자인 단어는 인정되지 않습니다.
     */
    public boolean isValidWord(String prevWord, String word) {
        if(word.isEmpty() || word.length() == 1) {
            return true;
        }

        if(set.contains(word)) {
            return true;
        }

        return prevWord.charAt(prevWord.length() - 1) != word.charAt(0);
    }




    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        영어_끝말잇기 res = new 영어_끝말잇기();
        System.out.println(Arrays.toString(res.solution(n, words)));;
    }
}
