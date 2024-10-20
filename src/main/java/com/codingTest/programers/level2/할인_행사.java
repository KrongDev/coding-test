package com.codingTest.programers.level2;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    // 체크할 맵
    Map<String, Integer> map = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        // 첫째 날 상품 셋팅
        for(int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;
        if(matches(want, number)) {
            answer++;
        }

        int len = discount.length;
        for(int i = 1; i <= len - 10; i++) {
            // 이전상품 삭제
            map.put(discount[i - 1], map.get(discount[i - 1]) - 1);
            // 추가 상품 추가
            map.put(discount[i + 9], map.getOrDefault(discount[i + 9], 0) + 1);

            if(matches(want, number)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean matches(String[] want, int[] number) {
        int len = want.length;
        for(int i = 0; i < len; i++) {
            if(map.getOrDefault(want[i], 0) != number[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        할인_행사 res = new 할인_행사();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(res.solution(want, number, discount));
    }
}
