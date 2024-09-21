package com.codingTest.programers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 방문_길이 {
    Map<Character, int[]> map;
    public 방문_길이() {
        map = new HashMap<>();
        map.put('U', new int[] {0, 1});
        map.put('D', new int[] {0, -1});
        map.put('R', new int[] {1, 0});
        map.put('L', new int[] {-1, 0});
    }

    public int solution(String dirs) {
        int len = dirs.length();
        Set<String> set = new HashSet<>();

        int x = 0;
        int y = 0;
        for(int i = 0; i < len; i++) {
            int[] move = map.get(dirs.charAt(i));

            int cx = x + move[0];
            int cy = y + move[1];
            if(cx < -5 || cx > 5 || cy < -5 || cy > 5 )
                continue;
            set.add(String.format("%d%d%d%d", x, y, cx, cy));
            set.add(String.format("%d%d%d%d", cx, cy, x, y));
            x = cx;
            y = cy;
        }

        return set.size()/2;
    }

    public static void main(String[] args) {
        방문_길이 res = new 방문_길이();

        String dirs = "ULURRDLLU";
        System.out.println(res.solution(dirs));
    }
}
