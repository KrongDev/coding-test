package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1002 {


    /**
     * 백준 1002 터렛
     * 원 두개가 존재하고 해당 원들이 겹치는 부분을 체크하여 몇개의 부분이 겹치는지 알려줘야한다.
     * #
     * 입력:
     * 첫째 줄에 테스트 케이스의 개수 T
     * 다음 줄부터 (x1, y1, r1), (x2, y2, r2)
     * #
     * 출력:
     * 두 원이 겹치는 점의 갯수를 출력
     * 원이 완전 겹친다면 -1을 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while((T--) > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            //원이 겹친 경우
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append("\n");
                continue;
            }
            // 두 원의 중심점 사이의 거리
            double originC = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
            double maxR = Math.max(r1, r2);
            double minR = Math.min(r1, r2);
            double plus = Math.pow(maxR + minR,2);
            double minus = Math.pow(maxR - minR,2);
            // 원이 서로 닿아있지 않은경우 - default
            int res = 0;
            //원이 원안에 들어가 있지 않은 경우
            if(minus < originC && plus > originC) res = 2;
                //원과 원이 한점만 닿아있을 경우
            else if(plus == originC || minus == originC) res = 1;

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
