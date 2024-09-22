package com.codingTest.programers.level2;

import java.util.*;

public class 괄호_회전하기 {
    Map<Character, Integer> map;

    public 괄호_회전하기() {
        map = new HashMap<>();
        map.put('(', 0);
        map.put('[', 1);
        map.put('{', 2);
        map.put(')', 3);
        map.put(']', 4);
        map.put('}', 5);
    }

    public int solution(String s) {
        int len = s.length();

        int answer = 0;

        boolean flag;
        Stack<Character> checkPoint;

        int point = 0;
        for(int i = 0; i < len; i++){
            flag = false;
            checkPoint = new Stack<>();
            for(int j = 0; j < len; j++){
                char c = s.charAt((j + point)%len);
                int index = map.get(c);
                if(index < 3) {
                    checkPoint.push(c);
                } else {
                    if(checkPoint.isEmpty()) {
                        flag = true;
                        break;
                    }
                    char check = checkPoint.pop();
                    int prevIndex = map.get(check);
                    if(prevIndex != index%3) {
                        flag = true;
                        break;
                    }
                }
            }
            if(checkPoint.isEmpty() && !flag) {
                answer++;
            }
            point++;
        }

        return answer;
    }

    public static void main(String[] args) {
        괄호_회전하기 res = new 괄호_회전하기();
        System.out.println(res.solution("}]()[{"));
    }
}
