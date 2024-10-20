package com.codingTest.programers.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        // 완주한 선수 목록
        Map<String, Integer> map = new HashMap<>();
        for(String complete: completion){
            map.put(complete, map.getOrDefault(complete,0) + 1);
        }

        for(String man: participant) {
            int count = map.getOrDefault(man, 0);
            if(count > 0) {
                map.put(man, count - 1);
                continue;
            }
            return man;
        }
        return "";
    }

    public static void main(String[] args) {
         완주하지_못한_선수 res = new 완주하지_못한_선수();
         String[] participant = {};
         String[] completion = {};
         System.out.println(res.solution(participant, completion));
    }
}
